import { FaUserCircle } from "react-icons/fa";


import './Header.scss'
import { Link, useNavigate } from "react-router-dom";



const Header = () => {


    const navigate = useNavigate()

    return (
        <header className="header">
            <Link className="title" to="/"><h1><strong>Ai.</strong>Commerce</h1></Link>
            <div className='menu'>
                <FaUserCircle onClick={() => { navigate("/user") }} className='icon' />
            </div>
        </header>
    )
}

export default Header