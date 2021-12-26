import { Box, Input, Typography } from "@material-ui/core";
import { Search } from "@material-ui/icons";
import React, { useEffect, useState } from "react";
import { data as MembersDatabase } from "../data";
import { Stack } from "@mui/material";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import {
  Avatar,
  Button,
  Divider,
  ListItemIcon,
  ListItemText,
  MenuList,
  Paper,
} from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import ProfileModal from "./ProfileModal";
import { setOpenProfilModal, setProfilData } from "../store/profilSlice";

export default function ClubModalPeople({ data }) {
  const [memberData, setMemberData] = useState([]);
  const dispatch = useDispatch();
  const profilData = useSelector((state) => state.profil.data);
  const { openProfilModal } = useSelector((state) => state.profil);

  useEffect(() => {
    setMemberData(
      MembersDatabase.filter((item) => {
        return item.clubsSubscribed.includes(data.clubName);
      })
    );
  }, [data]);

  return (
    <Box
      alignItems={"center"}
      sx={{
        width: "100%",
        height: "500px",
        display: "flex",
        justifyContent: "center",
      }}
    >
      <Box
        sx={{
          width: "300px",
          height: "400px",
          backgroundColor: "#2074d4",
          border: "3px solid black",
          p: 1,
        }}
      >
        <Box
          sx={{
            width: "100%",
            height: "100%",
            backgroundColor: "#f8e4e4",
            overflowY: "auto",
          }}
        >
          <Box
            sx={{
              width: "100%",
              height: "50px",
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
            }}
          >
            <Typography variant="h5">
              <span style={{ color: "#2074d4" }}>Members</span>
            </Typography>
          </Box>
          <Divider />
          {memberData.map((item) => {
            return (
              <Box
                sx={{ cursor: "pointer" }}
                onClick={() => {
                  dispatch(setProfilData(item));
                  dispatch(setOpenProfilModal(true));
                }}
              >
                <Stack
                  direction="row"
                  spacing={2}
                  alignItems="center"
                  justifyContent="space-evenly"
                >
                  <Avatar src={item.profilPicture} />
                  <Box width={"100px"}>
                    <Typography>{item.name}</Typography>
                  </Box>
                  <PersonAddIcon style={{ color: "#2074d4" }} />
                  <ChatBubbleIcon style={{ color: "#2074d4" }} />
                </Stack>
                <Divider />
              </Box>
            );
          })}
        </Box>
      </Box>
      <ProfileModal open={openProfilModal} />
    </Box>
  );
}
