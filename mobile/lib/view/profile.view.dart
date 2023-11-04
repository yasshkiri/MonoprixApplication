import 'dart:io';

import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:myapp/localstorage/loginUser.dart';
import 'mission.view.dart';
import 'login.view.dart';

class ProfileView extends StatefulWidget {
  final LoginUser logininfo;
  const ProfileView({Key? key, required this.logininfo}) : super(key: key);

  @override
  State<ProfileView> createState() => _ProfileViewState();
}

class _ProfileViewState extends State<ProfileView> {
  File? _image;
  TextEditingController _firstNameController = TextEditingController(text: 'melek');
  TextEditingController _mailController = TextEditingController(text: 'melek@gmail.com');
  String _firstName='' ;
  String _email ='';

  Future<void> _getImage() async {
    final ImagePicker _picker = ImagePicker();
    final XFile? pickedFile =
    await _picker.pickImage(source: ImageSource.gallery);
    if (pickedFile != null) {
      setState(() {
        _image = File(pickedFile.path);
      });
    }
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
                // Handle the Home navigation here
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
                // Handle the Profile navigation here
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
        children: [
          Stack(
            children: [
              Container(
                width: double.infinity,
                height: 200.0,
                color: Colors.grey[300],
                child: _image != null
                    ? Image.file(
                  _image!,
                  fit: BoxFit.cover,
                )
                    : Image.network(
                  'https://source.unsplash.com/random/100x100',
                  fit: BoxFit.cover,
                ),
              ),
              Positioned(
                bottom: 0.0,
                left: 16.0,
                right: 16.0,
                child: GestureDetector(
                  onTap: _getImage,
                  child: CircleAvatar(
                    radius: 50.0,
                    backgroundImage: _image != null
                        ? FileImage(_image!)
                        : const NetworkImage(
                        'https://source.unsplash.com/random/100x100') as ImageProvider<Object>?,
                  ),
                ),
              ),
            ],
          ),
          const SizedBox(height: 16.0),
          Container(
            margin: const EdgeInsets.all(16.0),
            child: Column(
              children: [
                TextField(
                  decoration: InputDecoration(
                    labelText: 'Nom',
                    border: OutlineInputBorder(),
                  ),
                  controller: _firstNameController,
                  onChanged: (value) {
                    setState(() {
                      _firstName = value;
                    });
                  },
                ),
                const SizedBox(height: 16.0),
                TextField(
                  decoration: InputDecoration(
                    labelText: 'Mail',
                    border: OutlineInputBorder(),
                  ),
                  controller: _mailController,
                  onChanged: (value) {
                    setState(() {
                      _email = value;
                    });
                  },
                ),
              ],
            ),
          ),
          const Spacer(),
          ElevatedButton(
            onPressed: () {},
            style: ElevatedButton.styleFrom(primary: Colors.red),
            child: const Text('Enregistrer'),
          ),
          const SizedBox(height: 16.0),
        ],
      ),
    );
  }
}
