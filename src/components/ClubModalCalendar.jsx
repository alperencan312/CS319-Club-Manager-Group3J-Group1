
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import interactionPlugin, { DateClickArg } from "@fullcalendar/interaction";
import { useEffect, useState } from "react";
import Event from "./Event";
import { FormControl, Switch } from "@material-ui/core";
import {
  InputLabel,
  MenuItem,
  OutlinedInput,
  Select,
  Stack,
  TextareaAutosize,
  TextField,
  Typography,
} from "@mui/material";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { setActivityData, setopenActivityModal } from "../store/activitySlice";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

function flatten(arr) {
  var flat = [];
  for (var i = 0; i < arr.length; i++) {
    flat = flat.concat(arr[i]);
  }
  return flat;
}

export default function ClubModalCalendar({ open, close, clubData }) {
  const { data } = useSelector((state) => state.universities);
  const [events, setEvents] = useState([]);
  const [show, setShow] = useState(false);
  const [type, setType] = useState("Required");
  const [admin, setAdmin] = useState(false);
  const [selected, setSelected] = useState(new Date());
  const dispatch = useDispatch()

  const renderEventContent = (eventInfo) => {
    return (
      <div
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          cursor: "pointer",
        }}
      >
        <img alt="event" src={eventInfo.event.url} style={{ width: "90%" }} />
      </div>
    );
  };

 useEffect(() => {
    const clubs = data.map((item) => {
      return item.clubs.map((item2) => {
        return item2;
      });
    });
    var final = flatten(clubs);
    final = final.map((item) => {
      return item.activities;
    });
    final = flatten(final);
    
    setEvents(final.filter(item => {
      return item.clubId == clubData.clubId
    }));
  }, [data, clubData]);

  const handleDateClick = () => {
    setShow(true);
  };

  return (
    <Box
      sx={{
        display: "flex",
        justifyContent: "center",
      }}
    >
      <Box
        sx={{
          width: "900px",
          height: "500px",
          backgroundColor: "#2074d4",
          border: "3px solid black",
          p: 1,
        }}
        alignItems={"center"}
      >
        <Box
          sx={{
            width: "100%",
            height: "100%",
            backgroundColor: "#f8e4e4",
            overflowY: "auto",
          }}
        >
          <Event show={show} setShow={setShow}/>
            
          
          <FullCalendar
            plugins={[dayGridPlugin, interactionPlugin]}
            dateClick={handleDateClick}
            eventContent={renderEventContent}
            eventClick={(info) => {
              info.jsEvent.preventDefault();
              dispatch(
                setActivityData({
                  title: info.event.title,
                  url: info.event.url,
                  ...info.event.extendedProps,
                })
              );
              dispatch(setopenActivityModal(true));
            }}
            eventBackgroundColor="#ffe4e4"
            eventBorderColor="#ffe4e4"
            events={events}
          ></FullCalendar>
        </Box>
      </Box>
    </Box>
  );
}
