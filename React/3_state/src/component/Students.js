import { useRef } from "react";
import { useState } from "react";

export default function Students(){ 

    const list=[];
    const [studentList, setStudentList ] = useState([]) ;

    const idRef = useRef(null); 
    const nameRef = useRef(null);


    function enroll(){
        console.log( nameRef.current.value );
        console.log( idRef.current.value );
        list.push ( <li key={idRef.current.value}> 
            Welcome! {idRef.current.value}번  {nameRef.current.value} 
            </li>);
        setStudentList(list);
    }
    return (
        <div> 
            <ul> 
                {studentList} 
            </ul>

            <div className="Enrollment-Form">  
            <input type="text" placeholder="번호를 입력하세요" ref={idRef}/> 
            <input type="text" placeholder="이름을 입력하세요" ref={nameRef}/> 
            <button onClick={enroll}> 등록 </button>
            </div>
        </div>
    )
}