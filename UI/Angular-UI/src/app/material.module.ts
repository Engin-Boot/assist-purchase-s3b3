import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatRippleModule} from '@angular/material/core';
import {MatRadioModule} from '@angular/material/radio';
import { NgModule } from '@angular/core';

@NgModule({
    imports: [
        MatButtonModule, MatCheckboxModule, MatStepperModule, 
        MatFormFieldModule, MatInputModule, MatRippleModule, MatRadioModule
    ],
    exports: [
        MatButtonModule, MatCheckboxModule, MatStepperModule, 
        MatFormFieldModule, MatInputModule, MatRippleModule, MatRadioModule
    ]
})
export class MaterialModule {}
