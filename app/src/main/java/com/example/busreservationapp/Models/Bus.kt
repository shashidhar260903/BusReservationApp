package com.example.busreservationapp.Models

class Bus(
    var id:Int,
    var StartTime:String,
    var EndTime:String,
    var Price:Double,
    var TotalSeats:Int,
    var NumberOfSeatsLeft:Int,
    var DriverNo: Long,
    var FromPlace:String,
    var ToPlac:String,
){
}