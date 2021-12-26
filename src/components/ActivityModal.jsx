import { Box, Modal, Stack, Typography } from "@mui/material";
import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setopenActivityModal } from "../store/activitySlice";
import ThumbUpIcon from "@mui/icons-material/ThumbUp";
import ThumbDownIcon from "@mui/icons-material/ThumbDown";

export default function ActivityModal({ open }) {
  const { data } = useSelector((state) => state.activity);
  const dispatch = useDispatch();

  useEffect(() => {
    console.log(data);
  }, [data]);
  return (
    <Modal
      open={open}
      onClose={() => {
        dispatch(setopenActivityModal(false));
      }}
      sx={{ display: "flex", alignItems: "center", justifyContent: "center" }}
    >
      <Stack
        spacing={2}
        sx={{
          width: "700px",
          height: "700px",
          border: "3px solid black",
          p: 5,
          backgroundColor: "#ffe4e4",
        }}
        alignItems={"center"}
      >
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            width: "100%",
          }}
        >
          <img alt="club" src={data.url} style={{ width: "150px" }} />
        </Box>
        <Typography variant="h4">
          <span style={{ color: "#2074d4", fontWeight: "500" }}>
            {data.title?.toUpperCase()}
          </span>
        </Typography>
        <Stack sx={{ width: "80%" }} spacing={4}>
          <Box>
            <Typography>
              <span style={{ color: "#2074d4", fontWeight: "500" }}>
                Information:{" "}
              </span>
            </Typography>
            <Typography>
              <span>{data.information}</span>
            </Typography>
          </Box>
          <Box>
            <Typography>
              <span style={{ color: "#2074d4", fontWeight: "500" }}>Time:</span>
            </Typography>
            <Typography>
              <span>{data.time}</span>
            </Typography>
          </Box>
          <Box>
            <Typography>
              <span style={{ color: "#2074d4", fontWeight: "500" }}>
                Priority:
              </span>
            </Typography>
            <Typography>
              <span>{data.priority}</span>
            </Typography>
          </Box>
        </Stack>
        <Stack spacing={3}>
          <Stack direction={"row"} alignItems={'center'} spacing={2}>
            <Box
              sx={{
                width: "50px",
                height: "50px",
                borderRadius: "50%",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                backgroundColor: "#2074d4",
                cursor:'pointer'
              }}
            >
              <ThumbUpIcon style={{color:'white'}}/>
            </Box>
            <Typography>I will attend</Typography>
          </Stack>
          <Stack direction={"row"} alignItems={'center'} spacing={2}>
            <Box
              sx={{
                width: "50px",
                height: "50px",
                borderRadius: "50%",
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                backgroundColor: "#2074d4",
                cursor:'pointer'
              }}
            >
              <ThumbDownIcon style={{color:'white'}}/>
            </Box>
            <Typography>I will not attend</Typography>
          </Stack>
        </Stack>
      </Stack>
    </Modal>
  );
}
