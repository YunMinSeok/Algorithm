import React, { useState, useEffect, useRef } from "react";
import ReactDOM from "react-dom";

const useNetwork = onChange =>{
  const [status,setStatus] = useState(navigator.onLine);
  const handleChange= () =>{
    if(typeof onChange === "function"){
      onChange(navigator.onLine);
    }
    setStatus(navigator.onLine);
  }
  useEffect(()=>{
    window.addEventListener("online",handleChange);
    window.addEventListener("offline",handleChange);
    () => {
      window.removeEventListener("online",handleChange);
      window.removeEventListener("offline",handleChange);  
    }
  },[]);
  return status;
}

const App = () => {
  const handleNetworkChange = (online) =>{
    console.log(online ? "We just went online": "We are offline");
  }
   const onLine = useNetwork(handleNetworkChange);
   return (
    <div className="App">
      <h1>{onLine ? "Online": "Offline"}</h1>

    </div>
  );
};

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);
