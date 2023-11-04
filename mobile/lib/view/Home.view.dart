import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:geolocator/geolocator.dart';
import 'package:myapp/ulis/global.colors.dart';
import 'package:myapp/view/profile.view.dart';
import 'package:myapp/localstorage/loginUser.dart';
import 'package:url_launcher/url_launcher_string.dart';
import 'package:table_calendar/table_calendar.dart';

import 'Mission.view.dart';
import 'login.view.dart';

class HomeView extends StatefulWidget {
  final LoginUser loginhome;
  const HomeView({Key? key, required this.loginhome}) : super(key: key);

  @override
  _HomeViewState createState() => _HomeViewState();
}

class _HomeViewState extends State<HomeView> {
  List<dynamic> _missions = [];
  String locationMessage = 'Localisation Actuelle';
  late String lat;
  late String long;
  DateTime day = DateTime(2023,6,6);




  @override
  void initState() {
    super.initState();

    _getCurrentLocation();

  }




  Future<Position> _getCurrentLocation() async {
    bool serviceEnabled = await Geolocator.isLocationServiceEnabled();
    if(!serviceEnabled) {
      return Future.error('Location services are disabled');

    }
    LocationPermission permission = await Geolocator.checkPermission();
    if (permission == LocationPermission.denied){
      permission = await Geolocator.requestPermission();
      if (permission == LocationPermission.denied){
        return Future.error('Location permissions are denied');
      }
    }
    if (permission == LocationPermission.deniedForever){
      return Future.error('Location permissions are permaently denied , we cannot request permsion');
    }
    return await Geolocator.getCurrentPosition();
  }

  void navigateToView(BuildContext context, String view) {
    switch (view) {
      case 'Home':
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => HomeView(loginhome: widget.loginhome)),
        );
        break;
      case 'Missions':
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => MissionsView()),
        );
        break;
      case 'Profile':
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => ProfileView(logininfo: widget.loginhome)),
        );
        break;
      case 'Logout':
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (context) => LoginView()),
        );
        break;
    }
  }
  void _liveLocation(){
    LocationSettings locationSettings = const LocationSettings(
      accuracy: LocationAccuracy.high,
      distanceFilter: 100,
    );
    Geolocator.getPositionStream(locationSettings: locationSettings)
    .listen((Position position) {
      lat = position.latitude.toString();
      long = position.longitude.toString();
      setState(() {
        locationMessage = 'Latitude:  $lat , Longitude : $long' ;
      });
    });
  }

    Future<void> _openMap(String lat , String long) async{
    String googleURL=
        'https://www.google.com/maps/search/?api=1&query=$lat,$long';
    await canLaunchUrlString(googleURL)
        ?await launchUrlString(googleURL)
        :throw 'Could not launch $googleURL';
    }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Monoprix'),
        backgroundColor: GlobalColors.mainColor,
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            UserAccountsDrawerHeader(
              accountName: Row(
                children: [
                  Text('Bonjour, '),
                  Text('Melek', style: TextStyle(fontWeight: FontWeight.bold)),
                ],
              ),
              accountEmail: Text('${widget.loginhome.email}'),
              currentAccountPicture: CircleAvatar(
                backgroundImage: NetworkImage(
                  'https://source.unsplash.com/random/100x100',
                ),
              ),
              decoration: BoxDecoration(
                color: Colors.red,
              ),
            ),
            ListTile(
              leading: const Icon(Icons.home),
              title: const Text('Home'),
              onTap: () {
                Navigator.pop(context); // Close the drawer
                navigateToView(context, 'Home');
              },
            ),
            ListTile(
              leading: const Icon(Icons.assignment),
              title: const Text('Missions'),
              onTap: () {
                Navigator.pop(context); // Close the drawer
                navigateToView(context, 'Missions');
              },
            ),
            ListTile(
              leading: const Icon(Icons.person),
              title: const Text('Profile'),
              onTap: () {
                Navigator.pop(context); // Close the drawer
                navigateToView(context, 'Profile');
              },
            ),
            ListTile(
              leading: const Icon(Icons.logout),
              title: const Text('Log out'),
              onTap: () {
                Navigator.pop(context); // Close the drawer
                navigateToView(context, 'Logout');
              },
            ),
          ],
        ),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Hello, Melek',
                  style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 20),
                Text(
                  locationMessage,
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 20),
                SizedBox(height: 20),
                ElevatedButton(onPressed: () {
                  _getCurrentLocation().then((value) {
                    lat = '${value.latitude}';
                    long = '${value.longitude}';
                    setState(() {
                      locationMessage ='Latitude :$lat , Longitude: $long';
                    });
                    _liveLocation();
                  });
                },
                  style: ElevatedButton.styleFrom(
                    primary: Colors.red,
                  ),
                  child: const Text('Emplacement Actuel'),
                ),
                const SizedBox(height: 20),
                ElevatedButton(onPressed: (){
                  _openMap(lat,long);
                },
                  style: ElevatedButton.styleFrom(
                    primary: Colors.red,
                  ),
                    child: const Text('Google Map'),
                ),
              ],
            ),
          ),
          Expanded(
            child: Container(
              child : TableCalendar (
                rowHeight: 43,
                headerStyle:
                HeaderStyle(formatButtonVisible: false , titleCentered: true,),
                availableGestures: AvailableGestures.all,

                focusedDay: day,
                firstDay: DateTime.utc(2010,10,16),
                lastDay: DateTime.utc(2050,3,14),


              )
            ),
          ),
        ],

      ),
    );
  }
}
