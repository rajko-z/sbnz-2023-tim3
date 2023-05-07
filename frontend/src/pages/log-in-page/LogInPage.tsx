import Canvas from "../../components/canvas/Canvas";
import LogInForm from "../../components/forms/logInForm/LogInForm";

const LogInPage = () => {
    return (
        <Canvas
            image={require("../../assets/image/wallpaper.jpg")}>
            <LogInForm/>
        </Canvas>
    );
}
export default LogInPage;