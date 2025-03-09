package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearSlide {
    private DcMotor slideMotor;
    private static final int EXTEND_POS = 5000; //tune lai
    private int curPos;
    private static final double SPEED = 1.0;

    public LinearSlide(HardwareMap hardwareMap) {
        slideMotor = hardwareMap.get(DcMotor.class, "slideMotor");
        slideMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideMotor.setPower(SPEED);
        curPos = 0;
        slideMotor.setTargetPosition(curPos);
        slideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void fullyExtend() {
        curPos = EXTEND_POS;
        slideMotor.setTargetPosition(curPos);
    }

    public void control(double power) {
        curPos += power;
        if (curPos > EXTEND_POS) curPos = EXTEND_POS;
        else if (curPos < 0) curPos = 0;
        slideMotor.setTargetPosition(curPos);
    }

}
