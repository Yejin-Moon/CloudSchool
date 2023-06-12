import { useState } from "react" ; 

export default function Hello() {
   const [user, setUser] = useState({id:1,name:"moon"}) ;
   function test(){
      user.name="lee"; 
      let NewUser = {...user, name:"lee"};  //새로운 객체 생성
      setUser(NewUser); 

   }
   return (
      <button onClick={test}>{user.name} </button>
   )
}