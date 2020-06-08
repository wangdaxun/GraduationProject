import React, {Component} from 'react';
import { BrowserRouter, Route, Switch, Redirect} from 'react-router-dom';
import './common.css';
import './App.css';
import Home from "./routes/home/index";
import Login from "./routes/userLog/Login";
import SignUp from "./routes/userLog/SignUp";
import JobIndex from "./routes/job/JobIndex";
import CompanyIndex from "./routes/company/CompanyIndex";
import ResumeIndex from "./routes/resume/ResumeIndex";
import UserCenter from "./routes/userLog/UserCenter";
import JobDetail from "./routes/job/JobDetail";
import CompanyDetail from "./routes/company/CompanyDetail";

class App extends Component {
  render() {
    return (
        <BrowserRouter>
          <Switch>
            <Route path="/" exact component={Home}/>
            <Route path="/index" exact component={Home}/>
            <Route path="/signUp" exact component={SignUp}/>
            <Route path="/logIn" exact component={Login}/>
            <Route path="/job" exact component={JobIndex}/>
            <Route path="/company" exact component={CompanyIndex}/>
            <Route path="/resume" exact component={ResumeIndex}/>
            <Route path="/userCenter" exact component={UserCenter}/>
            <Route path="/jobDetail" exact component={JobDetail}/>
            <Route path="/companyDetail" exact component={CompanyDetail}/>
          </Switch>
        </BrowserRouter>
    );
  }
}

export default App;
