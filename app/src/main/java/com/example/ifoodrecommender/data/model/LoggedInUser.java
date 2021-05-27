package com.example.ifoodrecommender.data.model;

public class LoggedInUser {

    // user profile data
    private String _id, _uname, _name;
    private int _weight, _height;
    private double _sugarBloodLevel;
    private int _waist, _age;
    private String _gender;
    private String password;
    private double BMI, BodyFat, WH;


    public LoggedInUser(String id, String uname) {
        this.set_id(id);
        this.set_uname(uname);
        this.set_name("App User"); // default name
    }
    public LoggedInUser() {
    }

    public String get_id() {
        return _id;
    }
    public String get_uname() {
        return _uname;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_uname(String _uname) {
        this._uname = _uname;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_weight() {
        return _weight;
    }

    public void set_weight(int _weight) {
        this._weight = _weight;
    }

    public int get_height() {
        return _height;
    }

    public void set_height(int _height) {
        this._height = _height;
    }

    public double get_sugarBloodLevel() {
        return _sugarBloodLevel;
    }

    public void set_sugarBloodLevel(double _sugarBloodLevel) {
        this._sugarBloodLevel = _sugarBloodLevel;
    }

    public int get_waist() {
        return _waist;
    }

    public void set_waist(int _waist) {
        this._waist = _waist;
    }

    public int get_age() {
        return _age;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }
    public void CalculateHelthIndicators() {
        //update heath indicators
        BMI = ((_weight * 1.0) / ((_height /10.0) * (_height /10.0)));
        BodyFat = _weight - ((_weight * 1.082) + 94.42) - (_waist * 4.15);
        WH = (_weight * 1.0 / _height);
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getBodyFat() {
        return BodyFat;
    }

    public void setBodyFat(double bodyFat) {
        BodyFat = bodyFat;
    }

    public double getWH() {
        return WH;
    }

    public void setWH(double WH) {
        this.WH = WH;
    }
}
