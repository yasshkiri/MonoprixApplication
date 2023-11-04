import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_barcode_scanner/flutter_barcode_scanner.dart';
import 'package:myapp/ulis/global.colors.dart';

import 'Scanform.view.dart';
import 'login.view.dart';
import 'mission.view.dart';

class MissionDetailsView extends StatefulWidget {
  const MissionDetailsView({Key? key}) : super(key: key);

  @override
  _MissionDetailsViewState createState() => _MissionDetailsViewState();
}

class _MissionDetailsViewState extends State<MissionDetailsView> {
  String? scanResult ;

  Future<void> scanBarcode() async {
    try {
      String value = await FlutterBarcodeScanner.scanBarcode('#FF0000', 'cancel', true, ScanMode.BARCODE);
      setState(() {
        scanResult = value;
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => ScanformView(scanResult: value)),
        );
      });
    } catch (e) {
      setState(() {
        scanResult = 'Unable to read the barcode';
      });
    }
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
            const UserAccountsDrawerHeader(
              accountName: Text('melek'),
              accountEmail: Text('melek@gmail.com'),
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
              },
            ),
            ListTile(
              leading: const Icon(Icons.assignment),
              title: const Text('Missions'),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MissionsView()),
                );
              },
            ),
            ListTile(
              leading: const Icon(Icons.person),
              title: const Text('Profile'),
              onTap: () {
                Navigator.pop(context); // Close the drawer
              },
            ),
            ListTile(
              leading: const Icon(Icons.logout),
              title: const Text('Log out'),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => LoginView()),
                );
              },
            ),
          ],
        ),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'CARRFOUR MARKET LAFAYETTE',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              'RUE LA PALESTINE-70 938 000',
              style: TextStyle(fontSize: 16),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(
              '${DateTime.now()}',
              style: TextStyle(fontSize: 14),
            ),
          ),
          Expanded(
            child: Align(
              alignment: Alignment.bottomCenter,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: ElevatedButton(
                  onPressed: scanBarcode,
                  style: ElevatedButton.styleFrom(
                    primary: Colors.red,
                    padding: EdgeInsets.symmetric(vertical: 16),
                  ),
                  child: Text(
                    'Démarrer',
                    style: TextStyle(fontSize: 18),
                  ),
                ),
              ),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              scanResult == null ? 'Scan a code!'
                  : 'Scan Result: $scanResult',
              style: TextStyle(fontSize: 16),
            ),
          ),
        ],
      ),
    );
  }
}
