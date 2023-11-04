import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

import 'user.dart';
import 'package:myapp/localstorage/loginUser.dart' ;
import 'Home.view.dart';
import 'package:myapp/ulis/global.colors.dart';
import 'package:myapp/view/widgets/button.global.dart';
import 'package:myapp/view/widgets/text.form.global.dart';

class LoginView extends StatefulWidget {
  const LoginView({Key? key}) : super(key: key);

  @override
  _LoginViewState createState() => _LoginViewState();
}

class _LoginViewState extends State<LoginView> {
  final _formKey = GlobalKey<FormState>();
  User user = User("","");
  String url = "http://192.168.1.16:8084/api/login";


  Future<void> save() async {
    var uri = Uri.parse(url);
    var res = await http.post(uri,
        headers: {'Content-Type': 'application/json'},
        body: json.encode({'email': user.email, 'password': user.password}));
        print(res.body);
    if (res.statusCode == 200) {
      var loginUser = LoginUser.fromJson(jsonDecode(res.body));
      print('id: ${loginUser?.id}, email: ${loginUser?.email}, name: ${loginUser?.name}, token: ${loginUser?.token}');
      Navigator.push(
        context,
        MaterialPageRoute(
          builder: (context) => HomeView(loginhome:loginUser),
        ),
      );
    }
  }

  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  bool _stayLogged = false;

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: SafeArea(
          child: Container(
            color: Colors.white,
            width: double.infinity,
            padding: const EdgeInsets.all(15.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(height: 15),
                Container(
                  alignment: Alignment.center,
                  child: Image.asset(
                    'images/Monoprixlogo2.png',
                    height: 200,
                    width: 200,
                  ),
                ),
                const SizedBox(height: 50),
                Text(
                  'Login votre compte',
                  style: TextStyle(
                    color: GlobalColors.textColor,
                    fontSize: 16,
                    fontWeight: FontWeight.w500,
                  ),
                ),
                const SizedBox(height: 15),
                //Email
                TextFormGlobal(
                  controller: emailController,
                  text: 'Email',
                  obscure: false,
                  textInputType: TextInputType.text,
                  initialValue: '',
                  onChanged: (value) {
                    user.email=value ;                  },
                ),
                const SizedBox(height: 6),
                //Password
                TextFormGlobal(
                  controller: passwordController,
                  text: 'Password',
                  textInputType: TextInputType.text,
                  obscure: true,
                  initialValue:'' ,
                  onChanged: (value) {
                    user.password = value; // update the password variable
                  },
                ),
                const SizedBox(height: 10),
                ElevatedButton(
                  onPressed: () {
                    save();
                  },
                  style: ElevatedButton.styleFrom(primary: Colors.red),
                  child: Text('Login'),
                ),
                const SizedBox(height: 10),
                CheckboxListTile(
                  title: Text(
                    'Restez Connecté',
                    style: TextStyle(
                      color: GlobalColors.textColor,
                      fontSize: 16,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                  value: _stayLogged,
                  onChanged: (value) {
                    // Update the state of _stayLogged when the checkbox is changed
                    setState(() {
                      _stayLogged = value!;
                    });
                  },
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
