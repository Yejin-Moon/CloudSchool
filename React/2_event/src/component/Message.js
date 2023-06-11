import {useRef} from "react";

export default function Message(){
    function onClickHandle(){
        console.log("clicked");
        console.log(nameRef.current.value);
        alert(nameRef.current.value + "님 반갑습니다.");
    }
    function onChangeName(event){
        console.log(event.target.value); 
    }

    const nameRef = useRef(null);//초기값은 null

    return (
        <div> 
             Welcome! 
             <input type="text" onChange={onChangeName} ref={nameRef} /> 
             카카오클라우드컴퓨팅 
            <button onClick={onClickHandle}>Click</button>
        </div>
    )
}