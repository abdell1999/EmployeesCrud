import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  employees: Employee[] = [];
  loading:boolean = true;
  empty:boolean = false;
  page: number = 1;
  numberElements:number = 10;
  newValue:number = 10;

  constructor(public employeeService: EmployeeService) {
    this.loading = true;
   }

  ngOnInit(): void {
    this.employeeService.getAll().subscribe((data: Employee[])=>{
      this.employees = data;
      this.loading = false;
      console.log(this.employees);
      this.checkEmpty(this.employees.length);
    })
  }


  checkEmpty(length:number){
    if(length>0){
      this.empty = false;
    }else{
      this.empty = true
    }
  }


  changeNumberElements(){

    this.numberElements = this.newValue;
    //console.log(this.newValue);

  }

  deleteEmployee(id:number){
    this.employeeService.delete(id).subscribe(res => {
         this.employees = this.employees.filter(item => item.id !== id);
         console.log(`El empleado con id ${id} ha sido eliminado correctamente`);
    })
  }


}
