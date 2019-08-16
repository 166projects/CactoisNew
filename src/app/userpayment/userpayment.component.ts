import { Component, OnInit } from '@angular/core';
import { userservice } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { FormsModule, FormGroup, Validators, FormBuilder  } from '@angular/forms';
@Component({
  selector: 'app-userpayment',
  templateUrl: './userpayment.component.html',
  styleUrls: ['./userpayment.component.css']
})
export class UserpaymentComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  constructor(private formBuilder: FormBuilder,private userservice: userservice,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      cardno: ['',[Validators.required, Validators.minLength(3)]],
      cardname: ['', Validators.required],
      expdate: ['', Validators.required],
      cvv: ['', [Validators.required, Validators.minLength(3)]],
      
      
  });
  }
  get f() { return this.registerForm.controls; }
  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
  
    // display form values on success
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value, null, 4));
    console.log("Payment Done");
    this.router.navigate(['/ride']);
}
  // conformpayment(): void{
  //   console.log("Payment Done");
  //   this.router.navigate(['/ride']);
  // }
}
