import {Box, CircularProgress, CircularProgressProps, Typography} from "@mui/material";
import Classes from "./CircularProgressWithLabel.module.scss";

function CircularProgressWithLabel(
    props: CircularProgressProps & { value: number, title: string },
) {
    return (
        <div className={Classes.box}>
            <Typography
                variant="caption"
                component="div"
                color="text.secondary"
                className={Classes.title}
            >{props.title}</Typography>
            <Box sx={{position: 'relative', display: 'inline-flex'}}>
                <CircularProgress variant="determinate" {...props} className={Classes.spinner}/>
                <Typography
                    variant="caption"
                    component="div"
                    color="text.secondary"
                    className={Classes.persentage}
                >{`${Math.round(props.value)}%`}</Typography>
            </Box>
        </div>
    );
}

export default CircularProgressWithLabel;