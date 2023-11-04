import 'package:flutter/material.dart';
import 'MissionDetails.view.dart';
import 'login.view.dart';
import 'Home.view.dart';
import 'profile.view.dart';
import 'package:http/http.dart' as http;
import 'Scanform.view.dart';



enum MissionType { price, range, articleList }

class Mission {
  final String name;
  final MissionType type;
  final bool isComplete;

  const Mission({
    required this.name,
    required this.type,
    this.isComplete = false,
  });
}

final List<Mission> allMissions = [
  Mission(
    name: 'Relevé sur liste des articles 1',
    type: MissionType.price,
  ),
  Mission(
    name: 'Relevé de gamme 1',
    type: MissionType.range,
  ),

];





class MissionsView extends StatefulWidget {

  const MissionsView({Key? key}) : super(key: key);


  @override
  _MissionsViewState createState() => _MissionsViewState();
}

class _MissionsViewState extends State<MissionsView> {
  MissionType _selectedType = MissionType.price;
  String _searchQuery = '';
  bool _showCompletedMissions = false;



  List<Mission> _getFilteredMissions() {
    return allMissions.where((mission) {
      if (!_showCompletedMissions && mission.isComplete) {
        return false;
      }

      if (_selectedType != MissionType.values[0] && mission.type != _selectedType) {
        return false;
      }

      final missionNameLower = mission.name.toLowerCase();
      final searchQueryLower = _searchQuery.toLowerCase();

      return missionNameLower.contains(searchQueryLower);
    }).toList();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Monoprix'),
        backgroundColor: Colors.red,
      ),
      drawer: Drawer(
        child: ListView(
          children: [
            const UserAccountsDrawerHeader(
              accountName: Text('agent007'),
              accountEmail: Text('agent007@gmail.com'),
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
      body: ListView(
        children: _getFilteredMissions()
            .map((mission) => _buildProductCard(mission.name))
            .toList(),
      ),
    );
  }

  Widget _buildProductCard(String name) {
    return Card(
      margin: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),
      child: ListTile(
        title: Text(name),
        subtitle: const Text('Description de mission'),
        trailing: ElevatedButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => MissionDetailsView()),
            );
          },
          style: ButtonStyle(
            backgroundColor: MaterialStateProperty.all<Color>(Colors.red),
          ),
          child: const Text('Consulter'),
        ),
        onTap: () {

        },
      ),
    );
  }
}

