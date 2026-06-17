import { useState } from "react";
import { useEffect } from "react";
import {useContext} from "react";
import {AuthContext} from "./context/AuthContext";
import StudentCard from "./components/StudentCard";
import StudentForm from "./components/StudentForm";

function App(){
    
/*
    //{"id":1,"name":"John Doe","course":"Computer Science"}

    const [students, setStudents] = useState([]);
    const [count, setCount] = useState(0);
    
    const [name, setName] = useState("");
    const [course, setCourse] = useState("");

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const {user, setUser} = useContext(AuthContext);

    const [search, setSearch] = useState("");

    const login  = async () => {
        const response = await fetch('http://localhost:8080/auth/login',
            {
                method: "POST",
                headers:{
                    "Content-Type":
                    "application/json"
                },
                body:JSON.stringify({
                    username,
                    password
                })
            }
        );
    
        alert("Login Success");
    }
    const loginWithGoogle = () => {

        window.location.href =
        "http://localhost:8080/oauth2/authorization/google-success";
    
    };
    
    const getStudents = async () => {
        
            const response = await fetch('http://localhost:8080/students');
            const data = await response.json();
            setStudents(data);
        
    };

    const getMCAStudents = async () => {
        const response = await fetch('http://localhost:8080/students/mca');
        const data = await response.json();
        setStudents(data);
    };


    const fetchTotalStudentCount = async () => {
        const response = await fetch('http://localhost:8080/students/count');
        const data = await response.json();
        setCount(data);
    };

    const addStudent = async () => {
        await fetch ('http://localhost:8080/students/count');
        {
            method: "POST",
            headers; { 
                "Content-Type"; "application/json"

            } 
            body; JSON.stringify ({
                name,
                cousre
            });
            if (response.ok) {
                alert('Student registered successfully');
            } else {
                alert('Failed to register student')
            }
        }
    }
  
    

    return (
        <div 
        style={{
            padding:"20px"
        }}
        >
            <h1>
		    Welcome { user ? user : "Guest" }
		</h1>
		
		<button onClick={() => setUser("Admin")}>
		    Login
		</button>


            <button onClick={getStudents}>
                fetch Students
            </button>

            <button onClick={getMCAStudents}>
                fetch MCA Students
            </button>

            

            <ul>
                {students.map(student => (
                    <li key={student.id}>
                        {student.name} - {student.course}
                    </li>
                ))}
            </ul>


            <button onClick={fetchTotalStudentCount}>
                Fetch Total Student Count
            </button>
            <p>Total Students: {count}</p>

        <h1>Student Registration Form</h1>
        <input 
        type="text" 
        placeholder="Name" 
        value={name} 
        onChange={(e) => setName(e.target.value)}/>

        <input type="text" 
        placeholder="Course" 
        value={course} 
        onChange={(e) => setCourse(e.target.value0)}/>  

        <button onClick={addStudent}>Register</button>

        <h1>Authentication Requires</h1>
        <input
        placeholder="Username"
        value={username}
        onChange={(e)=>
        setUsername(
            e.target.value
        )}
    />

    <input
        placeholder="Password"
        value={password}
        onChange={(e)=>
        setPassword(
            e.target.value
        )}
    />

    <button
    onClick={login}
    >
        Login
    </button>

    <h1>Student Management System</h1>

    <button onClick={loginWithGoogle}>
        Login with Google
    </button>

    <h1>Student Management System</h1>

    <StudentForm refreshStudents={fetchStudents}/>

    <hr/>

    {

        students.map((student) => (

            <StudentCard
            key={student.id}
            name={student.name}
            course={student.course}
            email={student.email}
            />
        )
        )
    }


    
        </div>
    ) */
        const [students,setStudents] = useState([]);
        const fetchStudents = async () => {
    
            const response = await fetch("http://localhost:8080/students");
            const data = await response.json();
        
            setStudents(data);
            };
        
            if (!response.ok) {
                alert("Unauthorized!");
                return;
            }
        
            const data = await response.json();
            setStudents(data);
        };
        useEffect(() => {
    
        fetchStudents();
    
        }, []);
    
        return (
    
        <div
            style={{
            padding:"20px"
            }}
        >
    
            <h1>Student Management System</h1>
    
            <StudentForm refreshStudents={fetchStudents}/>
    
            <hr/>
    
            {
    
            students.map((student) => (
    
                <StudentCard
                    key={student.id}
                    name={student.name}
                    course={student.course}
                    email={student.email}
                    
                />
                )
            )
            }
    
        </div>
    
        );
    
}
export default App;