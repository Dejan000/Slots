import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";


const SlotTabla = (props) =>{

    // const[ulog,setUlog]  = useState(1)

    let polja = []
    polja = Object.values(props.polja)
    
    let poljaSort = polja.sort((a,b) =>{
        if(a.red !== b.red)
            return a.red-b.red
        return a.kolona - b.kolona
    })

   
    console.log(polja)
    // console.log(poljaSort)
    // console.log(props.isplata)
    
    const renderTable = () => {
        let table = [];
        let indeks = 0;
       
        for (let i = 0; i < props.kolone; i++) {
          let children = [];
          
    
         
          for (let j = 0; j < props.redovi; j++) {
            children.push(<td style={{ fontSize: '100px' ,textAlign:'center',width: "200px"}} key={j}>{poljaSort[indeks]?.znak["oznaka"]? poljaSort[indeks].znak["oznaka"] :"spinuj"}</td>);
            indeks += 1;
          }
    
         
          table.push(<tr width="150px" height = "250px" key={i}>{children}</tr>);
        }
    
        
        return table;
      };

    

    return(<div>
        <Table >
            <tbody>
                {renderTable()}
            </tbody>
            <tfoot>
                <tr>
                    <td>Isplata:{props.isplata}</td>
                    <td>Ulog : {props.ulog}  <Button  onClick={()=>{props.setUlog(props.ulog+1)}}>+1</Button> <Button disabled={props.ulog <=1? true:false} onClick={()=>{props.setUlog(props.ulog-1)}}>-1</Button></td>
                    <td>
                        <Button disabled={props.balanceCheck<props.ulog?true:false} onClick = {() =>{
                        
                        props.spin();
                        
                                         }}>
                        Spin
                        </Button>
                    </td>
                </tr>
            </tfoot>
            
        </Table>
        
    </div>)

}

export default SlotTabla;