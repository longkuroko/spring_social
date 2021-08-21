
import './App.css';
// cấu hình routing
import { BrowserRouter, Route, Switch } from 'react-router-dom'
import LoginPage from './components/LoginPage/LoginPage';
import Home from './pages/Home/Home'
import Login from './pages/Login/Login'


function App() {
  return (
    <BrowserRouter>

      <Switch>
        <Route exact path="/home" component={Home} />
        <Route exact path="/" component={Login} />
      </Switch>

    </BrowserRouter>
  );
}

export default App;
