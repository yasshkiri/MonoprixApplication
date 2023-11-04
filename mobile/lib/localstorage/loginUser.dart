class LoginUser {
  final int id;
  final String email;
  final String name;
  final String token;

  LoginUser({required this.id, required this.email, required this.name, required this.token});

  factory LoginUser.fromJson(Map<String, dynamic> json) {
    return LoginUser(
      id: json['id'],
      email: json['email'],
      name: json['name'],
      token: json['token'],
    );
  }
}

