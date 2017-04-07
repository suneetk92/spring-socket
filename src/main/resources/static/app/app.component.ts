import {Component} from "@angular/core";
import {$WebSocket} from "./angular2-websocket";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';
  message = 'not known';
  ws: $WebSocket;

  init() {
    this.ws = new $WebSocket('ws://localhost:8080/counter/');
  }

  subscribe($event) {
    console.log('Trying to subscribe to ws');
    this.ws = new $WebSocket('ws://localhost:8080/counter/');
    console.log(this.ws);
    // this.ws.send('Hello');
    this.ws.getDataStream().subscribe(
      res => {
        const msg = JSON.parse(res.data).value;
        console.log('Got: ' + msg);
        this.message = msg;
      },
      function (e) {
        console.log('Error: ' + e.message);
      },
      function () {
        console.log('Completed');
      }
    );
  }
}
