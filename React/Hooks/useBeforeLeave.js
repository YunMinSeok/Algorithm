import React, { useState, useEffect, useRef } from "react";
import ReactDOM from "react-dom";

const useBeforLeave = (onBefore) =>{
  if(typeof onBefore !== "function"){
    return;
  }
  const handle = event =>{
    const {clientY} = event;
    if(clientY <= 0){
      onBefore();
    }
  };
  useEffect(()=>{
    document.addEventListener("mouseleave",handle);
    return () => document.removeEventListener("mouseleave",handle);
  },[]);
};

const App = () => {
   const begForLife = () => console.log("Pls dont leave");
   useBeforLeave(begForLife);
   return (
    <div className="App">
      <h1>Hello</h1>
    </div>
  );
};

const rootElement = document.getElementById("root");
ReactDOM.render(<App />, rootElement);
