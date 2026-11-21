// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Centimeters;
import static edu.wpi.first.units.Units.InchesPerSecond;
import static edu.wpi.first.units.Units.Seconds;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDStrip extends SubsystemBase {
  private AddressableLED m_led;
  private AddressableLEDBuffer m_buffer;
  private LEDPattern m_pattern;
  /** Creates a new LEDStrip. */
  public LEDStrip() {
  m_led = new AddressableLED(6);
  m_buffer = new AddressableLEDBuffer(60);
  m_led.setLength(m_buffer.getLength());
  //LEDPattern pattern = LEDPattern.solid(Color.fromHSV(127, 255, 255));
  m_pattern = LEDPattern.rainbow(255, 128);
  Distance kLedSpacing = Centimeters.of(1.6);
  m_pattern = m_pattern.scrollAtAbsoluteSpeed(InchesPerSecond.of(1), kLedSpacing);
  m_pattern = m_pattern.blink(Seconds.of(0.5));
  m_led.start();
  }
  @Override
  public void periodic() {
  m_pattern.applyTo(m_buffer);
  m_led.setData(m_buffer);
    // This method will be called once per scheduler run
  }
}
