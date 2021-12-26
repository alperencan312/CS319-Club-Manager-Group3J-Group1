import { Avatar, Box, Modal, Stack, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import { useDispatch, useSelector } from "react-redux";
import { setOpenProfilModal } from "../store/profilSlice";
import { Divider } from "@material-ui/core";
import BlockIcon from '@mui/icons-material/Block';

function ProfileModal({ open }) {
  const { data } = useSelector((state) => state.profil);
  const dispatch = useDispatch();
  return (
    <Modal
      open={open}
      onClose={() => {
        dispatch(setOpenProfilModal(false));
      }}
    >
      <Box
        sx={{
          width: "400px",
          height: "550px",
          position: "absolute",
          top: "50%",
          left: "58%",
          transform: "translate(-50%, -50%)",
          border: "solid 3px black",
          backgroundColor: "#f8e4e4",
          p: 3,
        }}
      >
        <Box
          sx={{
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-arround",
          }}
        >
          <Box
            sx={{
              display: "flex",
              flexDirection: "row",
              justifyContent: "space-between",
              marginBottom: "75px",
            }}
          >
            <Avatar
              src={data.profilPicture}
              sx={{ width: 100, height: 100, mx: 1 }}
              alt="Profile Picture"
            />
            <Divider orientation="vertical" flexItem />
            <Box
              sx={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "space-evenly",
                mx: 1,
              }}
            >
              <Typography>Name: {data.name}</Typography>
              <Typography>School: {data.school}</Typography>
              <Typography>School ID: {data.id}</Typography>
            </Box>
          </Box>
          <Box
            sx={{
              display: "flex",
              flexDirection: "row",
              justifyContent: "space-around",
            }}
          >
            <Box sx={{ display: "flex", flexDirection: "column" }}>
              <Box sx={{ display: "flex", flexDirection: "column" }}>
                <Typography variant="h6">
                  <span style={{ color: "#2074d4" }}>Clubs Subscribed:</span>

                  {data.clubsSubscribed?.map((item, index) => {
                    return <Typography key={index}>{item}</Typography>;
                  })}
                </Typography>
              </Box>
              <Box sx={{ display: "flex", flexDirection: "column" }}>
                <Typography variant="h6">
                  <span style={{ color: "#2074d4" }}>Clubs Directed:</span>
                  {data.clubsDirected?.map((item, index) => {
                    return <Typography key={index}>{item}</Typography>;
                  })}
                </Typography>
              </Box>
            </Box>
            <Box
              sx={{
                display: "flex",
                flexDirection: "column",
                justifyContent: "space-evenly",
              }}
            >
              <Stack
                direction={"row"}
                alignItems={"center"}
                justifyContent={"space-evenly"}
                sx={{ cursor: "pointer" }}
              >
                <PersonAddIcon style={{ color: "#2074d4" }} />
                <p>Add Friend</p>
              </Stack>
              <Stack
                direction={"row"}
                alignItems={"center"}
                justifyContent={"space-evenly"}
                spacing={2}
                sx={{ cursor: "pointer" }}
              >
                <BlockIcon style={{ color: "#2074d4" }} />
                <p> Block</p>
              </Stack>
              <Stack
                direction={"row"}
                alignItems={"center"}
                justifyContent={"space-evenly"}
                sx={{ cursor: "pointer" }}
              >
                <ChatBubbleIcon style={{ color: "#2074d4" }} />
                <p> Send message</p>
              </Stack>
            </Box>
          </Box>
        </Box>
      </Box>
    </Modal>
  );
}

export default ProfileModal;
