import { Avatar, Box, IconButton, Typography } from "@material-ui/core";
import { Stack } from "@mui/material";
import React from "react";
import HomeIcon from "@mui/icons-material/Home";
import EventIcon from "@mui/icons-material/Event";
import PeopleIcon from "@mui/icons-material/People";
import SettingsIcon from "@mui/icons-material/Settings";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import CloseIcon from "@mui/icons-material/Close";

export default function ClubModalHome({ data }) {
  return (
    <Box
      sx={{
        mt: 15,
        display: "flex",
        justifyContent: "space-between",
      }}
    >
      <Box>
        <Box
          sx={{
            border: "solid 3px #2074d4",
            width: "350px",
            height: "180px",
            py: 1,
            px: 2,
            overflowY: "auto",
            backgroundColor: "#66a6ed",
            mb: 5,
          }}
        >
          <Typography variant="h5">
            <span style={{ color: "red" }}>About:</span>{" "}
          </Typography>
          <Typography variant="body1">{data?.about} </Typography>
        </Box>
        <Box>
          <Stack spacing={2} direction="row" alignItems="center">
            <Typography variant="h5">
              <span style={{ color: "red" }}>Contact:</span>{" "}
            </Typography>
            <Box
              sx={{
                width: "80px",
                height: "80px",
                borderRadius: "50%",
                backgroundImage: `url(${data?.contact.contactImg})`,
                backgroundSize: "cover",
                backgroundPosition: "center",
              }}
            ></Box>

            <Typography variant="body1">
              <span style={{ color: "black" }}>
                {data?.contact.contactName}
              </span>{" "}
            </Typography>
            <Box
              backgroundColor="#4a96ed"
              sx={{
                cursor: "pointer",
                width: "50px",
                height: "50px",
                borderRadius: "50%",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
              }}
            >
              <Box
                sx={{
                  width: "50px",
                  height: "50px",
                  borderRadius: "50%",
                  backgroundColor: "#2074d4",
                  display: "flex",
                  alignItems: "center",
                  justifyContent: "center",
                }}
              >
                <ChatBubbleIcon style={{ color: "white" }} />
              </Box>
            </Box>
          </Stack>
          <Box sx={{ mt: 7 }}>
            <Typography variant="h6">
              <span style={{ color: "red" }}>
                {data?.acceptOthers
                  ? "*This club accepts from other schools."
                  : "*This club does not accept from other schools."}
              </span>
            </Typography>
          </Box>
        </Box>
      </Box>
      <Box
        sx={{
          border: "solid 3px #2074d4",
          width: "550px",
          height: "380px",
          py: 2,
          px: 3,
          overflowY: "auto",
          backgroundColor: "#66a6ed",
        }}
      >
        <Stack spacing={4}>
          <Box
            sx={{
              width: "100%",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
            }}
          >
            <Typography variant="h5">
              <span style={{ color: "red", fontWeight: "bold" }}>
                Announcements
              </span>
            </Typography>
          </Box>
          {data?.announcements.map((item, index) => {
            return (
              <Stack
                spacing={2}
                direction="row"
                key={index}
                alignItems={"center"}
              >
                <Box
                  sx={{
                    width: "150px",
                    height: "50px",
                    borderRadius: "50%",
                    backgroundImage: `url(${data?.contact.contactImg})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                  }}
                ></Box>
                <Typography variant="body1">{item.announcmentDesc}</Typography>
              </Stack>
            );
          })}
          {data?.announcements.map((item, index) => {
            return (
              <Stack
                spacing={2}
                direction="row"
                key={index}
                alignItems={"center"}
              >
                <Box
                  sx={{
                    width: "150px",
                    height: "50px",
                    borderRadius: "50%",
                    backgroundImage: `url(${data?.contact.contactImg})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                  }}
                ></Box>
                <Typography variant="body1">{item.announcmentDesc}</Typography>
              </Stack>
            );
          })}
        </Stack>
      </Box>
    </Box>
  );
}
