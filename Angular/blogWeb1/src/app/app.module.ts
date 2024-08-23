import { NgModule } from "@angular/core";
import { AppComponent } from "./app.component";
import { CreatePostComponent } from "./pages/create-post/create-post.component";
import { BrowserModule } from "@angular/platform-browser";
import { HttpClientModule } from "@angular/common/http";
import { AngularMaterialModule } from "./AngularMaterialModule";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatChipsModule } from '@angular/material/chips';
import { ViewAllComponent } from './pages/view-all/view-all.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { ViewPostComponent } from './pages/view-post/view-post.component';
import { SearchByNameComponent } from './pages/search-by-name/search-by-name.component';


@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    ViewAllComponent,
    ViewPostComponent,
    SearchByNameComponent,
    
  ],
  imports: [
    MatChipsModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,        // Add HttpClientModule
    AngularMaterialModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatGridListModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
