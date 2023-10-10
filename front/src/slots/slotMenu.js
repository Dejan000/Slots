import { useState } from "react"
import Axios from "../apis/Axios"
import { useNavigate } from "react-router-dom"
import { Button } from "react-bootstrap";

const SlotMenu = (props) =>{

    const navigate = useNavigate();

    const getSlot = () =>{
      navigate("/slot/igra/" + props.proslediId);
    }

  return(
    <td onClick={()=>getSlot()}><Button>{"Slot" + props.proslediId} </Button></td>
  )
  



}
export default SlotMenu;
