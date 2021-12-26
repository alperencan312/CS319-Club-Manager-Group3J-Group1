import React, { useEffect } from "react";
import Box from "@mui/material/Box";
import ArrowCircleDownIcon from "@mui/icons-material/ArrowCircleDown";
import { styled } from "@mui/material/styles";
import { useDispatch, useSelector } from "react-redux";
import activitiesSlice, { setActivityData } from "../store/activitiesSlice";
import announcmentsSlice from "../store/announcmentsSlice";

const Div = styled("div")(({ theme }) => ({
  ...theme.typography.button,
  backgroundColor: "#1976D2",
  padding: theme.spacing(1),
  borderRadius: "3px",
  color: "white",
}));

function Sidebar() {
  const dispatch = useDispatch();
  
  
  const activities = useSelector((state) => state.activities.data);
  const announcements = useSelector((state) => state.announcements.data);

  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignContent: "space-between",
        width: "20%",
        height: "97%",
        backgroundColor: "white",
        padding: "2px",
        boxShadow: "2px 0 5px -10px #888",
        marginRight: "10px",
      }}
    >
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          justifyContent: "space-around",
          alignContent: "space-between",
          flexDirection: "column",
          height: "50%",
          marginBottom: "5%",
        }}
      >
        <Div>{"Upcoming Activities"}</Div>

        <Box
          sx={{
            backgroundColor: "white",
            display: "flex",
            alignItems: "center",
            overflowY: "auto",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          {activities.map((item, index) => {
            return (
              <Box
                sx={{
                  display: "flex",
                  flexDirection: "row",
                  WebkitBoxShadow: "4px 4px 10px -5px #888",
                  padding: "5%",
                  width: "100%",
                }}
                key={index}
              >
                <img alt="activity" src={item.clubImg} width="20%" />
                <Box
                  sx={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "center",
                    flexDirection: "column",
                    width: "100%",
                  }}
                >
                  <h4 style={{ margin: 0 }}>{item.title}</h4>
                  <p style={{ margin: 0, textAlign: "center", width: "100%" }}>
                    {item.day}
                  </p>
                  <Box sx={{ display: "flex", flexDirection: "row" }}>
                    <p
                      style={{
                        margin: 0,
                        textAlign: "left",
                        width: "100%",
                        marginRight: "5px",
                      }}
                    >
                      {item.time}
                    </p>
                    <button
                      style={{
                        backgroundColor: "#1976D2",
                        borderRadius: "3px",
                        border: "0",
                        cursor: "pointer",
                        marginLeft: "10px",
                        color: "white",
                        textAlign: "left",
                      }}
                    >
                      {" "}
                      Details>
                    </button>
                  </Box>
                </Box>
              </Box>
            );
          })}

          <ArrowCircleDownIcon sx={{ color: "#1976D2" }} fontSize="large" />
        </Box>
      </Box>
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          justifyContent: "space-around",
          alignContent: "space-between",
          flexDirection: "column",
          height: "50%",
          WebkitBoxShadow: "0px 4px 10px -5px #888",
          overflowY: "hidden",
        }}
      >
        <Div>{"Announcement"}</Div>

        <Box
          sx={{
            backgroundColor: "white",
            display: "flex",
            alignItems: "center",
            overflowX: "auto",
            flexDirection: "column",
          }}
        >
          {announcements.map((item, index) => {
            return (
              <Box
                key={index}
                sx={{
                  display: "flex",
                  flexDirection: "column",
                  WebkitBoxShadow: "4px 4px 10px -5px #888",
                  marginRight: "5%",
                  marginBottom: "5%",
                  padding: "5%",
                }}
              >
                <Box
                  sx={{
                    display: "flex",
                    flexDirection: "row",
                    justifyContent: "space-between",
                  }}
                >
                  <img alt="announcement" src={item.clubImg} width="20%" />
                  <h4 style={{ margin: 0 }}>{item.title}</h4>
                </Box>
                <p
                  style={{
                    overFlowX: "hidden",
                    overflowY: "auto",
                    height: "70px",
                    margin: "0",
                  }}
                >
                  {item.announcment}
                </p>
                <p style={{ margin: "5px" }}>{item.sent}</p>
              </Box>
            );
          })}
        </Box>
        <ArrowCircleDownIcon sx={{ color: "#1976D2" }} fontSize="large" />
      </Box>
    </Box>
  );
}

export default Sidebar;
