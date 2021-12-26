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
  TextField,
  TextareaAutosize,
  Typography,
} from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { useForm, submitHandler } from "react-hook-form";
import { setOpenCalendarModal } from "../store/myCalendarSlice";
import { useNavigate } from "react-router-dom";
import { setopenActivityModal, setActivityData } from "../store/activitySlice";
import ActivityModal from "./ActivityModal";

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

export default function BasicModal() {
  const { openActivityModal } = useSelector((state) => state.activity);
  const navigate = useNavigate();
  const { data } = useSelector((state) => state.universities);
  const [events, setEvents] = useState([]);
  const { openCalendarModal } = useSelector((state) => state.myCalendar);
  const [finalData, setFinalData] = useState();
  const dispatch = useDispatch();
  const [show, setShow] = useState(false);
  const [type, setType] = useState("Required");
  const [admin, setAdmin] = useState(false);
  const [selected, setSelected] = useState(new Date());

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
    setEvents(final);
  }, [data]);

  const handleDateClick = () => {
    setShow(true);
  };

  return (
    <div>
      <Modal
        open={openCalendarModal}
        onClose={() => {
          dispatch(setOpenCalendarModal(false));
        }}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box
          sx={{
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
            border: "solid 3px black",
            backgroundColor: "#f8e4e4",
            width: "1600px",
            height: "900px",
            p: 6,
            overflowY: "auto",
          }}
        >
          
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
          <ActivityModal open={openActivityModal} />
        </Box>
      </Modal>
    </div>
  );
}
