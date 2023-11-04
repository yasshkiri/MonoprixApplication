import 'dart:io';

import 'package:flutter/material.dart';
import 'package:image_picker/image_picker.dart';
import 'package:myapp/ulis/global.colors.dart';

class ScanformView extends StatefulWidget {
  final String scanResult;
  ScanformView({required this.scanResult});

  @override
  _ScanformViewState createState() => _ScanformViewState();
}

class _ScanformViewState extends State<ScanformView> {
  File? _image;
  late String value;
  TextEditingController _codeabarreController = TextEditingController();

  @override
  void initState() {
    super.initState();
    value = widget.scanResult;
    _codeabarreController = TextEditingController(text: value); 
  }


  Future<void> _pickImage(ImageSource source) async {
    final picker = ImagePicker();
    final pickedImage = await picker.pickImage(source: source);

    if (pickedImage != null) {
      setState(() {
        _image = File(pickedImage.path);
      });
    }
  }

  Future<void> _saveForm() async {
    // Perform form submission logic here
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Monoprix'),
          backgroundColor: GlobalColors.mainColor, // Set your desired background color
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
                onTap: () {},
              ),
              ListTile(
                leading: const Icon(Icons.assignment),
                title: const Text('Missions'),
                onTap: () {},
              ),
              ListTile(
                leading: const Icon(Icons.person),
                title: const Text('Profile'),
                onTap: () {},
              ),
              ListTile(
                leading: const Icon(Icons.logout),
                title: const Text('Log out'),
                onTap: () {},
              ),
            ],
          ),
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: ListView(
            children: [
              TextFormField(
                decoration: const InputDecoration(labelText: 'code à barre'),
                controller: _codeabarreController,
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter a barcode.';
                  }
                  return null;
                },
              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Description'),

              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Prix actuel'),
                keyboardType: TextInputType.number,
              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Prix précédent'),
                keyboardType: TextInputType.number,
              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Prix promotionnel'),
                keyboardType: TextInputType.number,
              ),
              Row(
                children: [
                  const Text('En stock:'),
                  Radio<bool>(
                    value: true,
                    groupValue: true,
                    onChanged: (bool? value) {},
                  ),
                  const Text('Yes'),
                  Radio<bool>(
                    value: false,
                    groupValue: true,
                    onChanged: (bool? value) {},
                  ),
                  const Text('No'),
                ],
              ),
              ElevatedButton(
                onPressed: () => _pickImage(ImageSource.camera),
                style: ElevatedButton.styleFrom(primary: Colors.red),
                child: const Text('Prendre une photo'),
              ),
              if (_image != null) Image.file(_image!),
            ],
          ),
        ),
        bottomNavigationBar: Padding(
          padding: const EdgeInsets.symmetric(vertical: 16.0, horizontal: 16.0),
          child: ElevatedButton(
            onPressed: _saveForm,
            style: ElevatedButton.styleFrom(primary: Colors.red),
            child: const Text('Enregistrer'),
          ),
        ),
      ),
    );
  }
}
