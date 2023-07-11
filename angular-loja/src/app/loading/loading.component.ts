import { Component } from '@angular/core';
import { MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { LoadingService } from './services/loading.service';
import { CommonModule } from '@angular/common';  

@Component({
  selector: 'app-loading',
  templateUrl: './loading.component.html',
  styleUrls: ['./loading.component.css'],
  standalone: true,
  imports: [
      MatProgressSpinnerModule,
      CommonModule
    ],
})
export class LoadingComponent {

  constructor(public loadingService: LoadingService ){
  }

}
