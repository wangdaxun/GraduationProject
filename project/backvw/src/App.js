import React, {Component} from 'react';
import { BrowserRouter, Route, Switch, Redirect} from 'react-router-dom';
import Home from "./routes/home/index";
import './common.css';
import './App.css';

class App extends Component {
  render() {
    return (
        <BrowserRouter>
          <Switch>
            <Route path="/" exact component={Home}/>
          </Switch>
        </BrowserRouter>
    );
  }
}

export default App;
