import { Box, InputLabel, Switch} from '@material-ui/core'
import { Stack } from '@mui/material';
import React, { useState } from 'react'

function ClubModalSettings() {
    const [notification, setNotification] = useState(false);

    return (
        <Box
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
                        display:'flex',
                        flexDirection:'column',
                        justifyContent:'center'
                        
                    }}
                >

                    <Stack direction="row" spacing={1} alignItems="center" sx={{marginBottom:'25px'}}>

                        <Switch
                            value={notification}
                            color='primary'
                            onClick={() => {
                                setNotification(!notification);
                            }}
                        />
                        <InputLabel>Send me notifications</InputLabel>

                    </Stack>
                    <Stack direction="row" spacing={1} alignItems="center">

                        <Switch
                            value={notification}
                            color='primary'
                            onClick={() => {
                                setNotification(!notification);
                            }}
                        />
                        <InputLabel>Make changes on my calendar</InputLabel>

                    </Stack>

                </Box>
            </Box>

        </Box>

    )
}

export default ClubModalSettings
