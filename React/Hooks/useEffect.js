import React , {useState,useEffect} from "react";
import ReactDOM from "react-dom";

import "./styles.css";

const App = () => {
  const sayHello = () => console.log("hello");
  const [number,setNumber] = useState(0);
  const [anumber,setAnumber] = useState(0);
  useEffect(sayHello,[number]);
  return (
    <div className="App">
      <div>Hi</div>
      <button onClick= {() => setNumber(number +1)}>{number}</button>
      <button onClick= {() => setAnumber(anumber +1)}>{anumber}</button>
    </div>
  );
}


const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);
