/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.se433;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author tmitic
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  edu.depaul.se433.CalculateTotalWeakNormalTest.class,
  edu.depaul.se433.CalculateTotalWeakRobustnessTest.class,
  edu.depaul.se433.CalculateTotalStrongNormalTest.class,
  edu.depaul.se433.CalculateTotalStrongRobustnessTest.class,
  edu.depaul.se433.CalculateTotalSpecialValuesTest.class
})
public class CalculateTotalTestSuite {}