package net.hemisoft.financial.calculator.library.utils

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.offset
import static org.junit.Assert.*

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized.class)
class AnnuityCalculatorCalculateInterestInYearTest {
    def capital, interest, redemption, specialRedemption, endOfYear, expected
    
    
    public AnnuityCalculatorCalculateInterestInYearTest(capital, interest, redemption, specialRedemption, endOfYear, expected) {
        this.capital = capital
        this.interest = interest
        this.redemption = redemption
        this.specialRedemption = specialRedemption
        this.endOfYear = endOfYear
        this.expected = expected
    }

    @Parameters static cases() {
        [
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,         0.0,                 0,            0.0d],
            [-100.0d,      1.0,           0.0,         0.0,                 1,            0.0d],
            [-100.0d,      1.0,           0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,         1.0,                 0,            0.0d],
            [-100.0d,      1.0,           0.0,         1.0,                 1,            0.0d],
            [-100.0d,      1.0,           0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           0.0,         10.0,                0,            0.0d],
            [-100.0d,      1.0,           0.0,         10.0,                1,            0.0d],
            [-100.0d,      1.0,           0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         0.0,                 0,            0.0d],
            [-100.0d,      1.0,           1.0,         0.0,                 1,            0.0d],
            [-100.0d,      1.0,           1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         1.0,                 0,            0.0d],
            [-100.0d,      1.0,           1.0,         1.0,                 1,            0.0d],
            [-100.0d,      1.0,           1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           1.0,         10.0,                0,            0.0d],
            [-100.0d,      1.0,           1.0,         10.0,                1,            0.0d],
            [-100.0d,      1.0,           1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        0.0,                 0,            0.0d],
            [-100.0d,      1.0,           10.0,        0.0,                 1,            0.0d],
            [-100.0d,      1.0,           10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        1.0,                 0,            0.0d],
            [-100.0d,      1.0,           10.0,        1.0,                 1,            0.0d],
            [-100.0d,      1.0,           10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      1.0,           10.0,        10.0,                0,            0.0d],
            [-100.0d,      1.0,           10.0,        10.0,                1,            0.0d],
            [-100.0d,      1.0,           10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         0.0,                 0,            0.0d],
            [-100.0d,      10.0,          0.0,         0.0,                 1,            0.0d],
            [-100.0d,      10.0,          0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         1.0,                 0,            0.0d],
            [-100.0d,      10.0,          0.0,         1.0,                 1,            0.0d],
            [-100.0d,      10.0,          0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          0.0,         10.0,                0,            0.0d],
            [-100.0d,      10.0,          0.0,         10.0,                1,            0.0d],
            [-100.0d,      10.0,          0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         0.0,                 0,            0.0d],
            [-100.0d,      10.0,          1.0,         0.0,                 1,            0.0d],
            [-100.0d,      10.0,          1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         1.0,                 0,            0.0d],
            [-100.0d,      10.0,          1.0,         1.0,                 1,            0.0d],
            [-100.0d,      10.0,          1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          1.0,         10.0,                0,            0.0d],
            [-100.0d,      10.0,          1.0,         10.0,                1,            0.0d],
            [-100.0d,      10.0,          1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        0.0,                 0,            0.0d],
            [-100.0d,      10.0,          10.0,        0.0,                 1,            0.0d],
            [-100.0d,      10.0,          10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        1.0,                 0,            0.0d],
            [-100.0d,      10.0,          10.0,        1.0,                 1,            0.0d],
            [-100.0d,      10.0,          10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-100.0d,      10.0,          10.0,        10.0,                0,            0.0d],
            [-100.0d,      10.0,          10.0,        10.0,                1,            0.0d],
            [-100.0d,      10.0,          10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         0.0,                 0,            0.0d],
            [-1.0d,        1.0,           0.0,         0.0,                 1,            0.0d],
            [-1.0d,        1.0,           0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         1.0,                 0,            0.0d],
            [-1.0d,        1.0,           0.0,         1.0,                 1,            0.0d],
            [-1.0d,        1.0,           0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           0.0,         10.0,                0,            0.0d],
            [-1.0d,        1.0,           0.0,         10.0,                1,            0.0d],
            [-1.0d,        1.0,           0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         0.0,                 0,            0.0d],
            [-1.0d,        1.0,           1.0,         0.0,                 1,            0.0d],
            [-1.0d,        1.0,           1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         1.0,                 0,            0.0d],
            [-1.0d,        1.0,           1.0,         1.0,                 1,            0.0d],
            [-1.0d,        1.0,           1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           1.0,         10.0,                0,            0.0d],
            [-1.0d,        1.0,           1.0,         10.0,                1,            0.0d],
            [-1.0d,        1.0,           1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        0.0,                 0,            0.0d],
            [-1.0d,        1.0,           10.0,        0.0,                 1,            0.0d],
            [-1.0d,        1.0,           10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        1.0,                 0,            0.0d],
            [-1.0d,        1.0,           10.0,        1.0,                 1,            0.0d],
            [-1.0d,        1.0,           10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        1.0,           10.0,        10.0,                0,            0.0d],
            [-1.0d,        1.0,           10.0,        10.0,                1,            0.0d],
            [-1.0d,        1.0,           10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         0.0,                 0,            0.0d],
            [-1.0d,        10.0,          0.0,         0.0,                 1,            0.0d],
            [-1.0d,        10.0,          0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         1.0,                 0,            0.0d],
            [-1.0d,        10.0,          0.0,         1.0,                 1,            0.0d],
            [-1.0d,        10.0,          0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          0.0,         10.0,                0,            0.0d],
            [-1.0d,        10.0,          0.0,         10.0,                1,            0.0d],
            [-1.0d,        10.0,          0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         0.0,                 0,            0.0d],
            [-1.0d,        10.0,          1.0,         0.0,                 1,            0.0d],
            [-1.0d,        10.0,          1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         1.0,                 0,            0.0d],
            [-1.0d,        10.0,          1.0,         1.0,                 1,            0.0d],
            [-1.0d,        10.0,          1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          1.0,         10.0,                0,            0.0d],
            [-1.0d,        10.0,          1.0,         10.0,                1,            0.0d],
            [-1.0d,        10.0,          1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        0.0,                 0,            0.0d],
            [-1.0d,        10.0,          10.0,        0.0,                 1,            0.0d],
            [-1.0d,        10.0,          10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        1.0,                 0,            0.0d],
            [-1.0d,        10.0,          10.0,        1.0,                 1,            0.0d],
            [-1.0d,        10.0,          10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [-1.0d,        10.0,          10.0,        10.0,                0,            0.0d],
            [-1.0d,        10.0,          10.0,        10.0,                1,            0.0d],
            [-1.0d,        10.0,          10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         0.0,                 0,            0.0d],
            [0.0d,         1.0,           0.0,         0.0,                 1,            0.0d],
            [0.0d,         1.0,           0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         1.0,                 0,            0.0d],
            [0.0d,         1.0,           0.0,         1.0,                 1,            0.0d],
            [0.0d,         1.0,           0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           0.0,         10.0,                0,            0.0d],
            [0.0d,         1.0,           0.0,         10.0,                1,            0.0d],
            [0.0d,         1.0,           0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         0.0,                 0,            0.0d],
            [0.0d,         1.0,           1.0,         0.0,                 1,            0.0d],
            [0.0d,         1.0,           1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         1.0,                 0,            0.0d],
            [0.0d,         1.0,           1.0,         1.0,                 1,            0.0d],
            [0.0d,         1.0,           1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           1.0,         10.0,                0,            0.0d],
            [0.0d,         1.0,           1.0,         10.0,                1,            0.0d],
            [0.0d,         1.0,           1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        0.0,                 0,            0.0d],
            [0.0d,         1.0,           10.0,        0.0,                 1,            0.0d],
            [0.0d,         1.0,           10.0,        0.0,                 10,           0.0d],
             
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        1.0,                 0,            0.0d],
            [0.0d,         1.0,           10.0,        1.0,                 1,            0.0d],
            [0.0d,         1.0,           10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         1.0,           10.0,        10.0,                0,            0.0d],
            [0.0d,         1.0,           10.0,        10.0,                1,            0.0d],
            [0.0d,         1.0,           10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         0.0,                 0,            0.0d],
            [0.0d,         10.0,          0.0,         0.0,                 1,            0.0d],
            [0.0d,         10.0,          0.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         1.0,                 0,            0.0d],
            [0.0d,         10.0,          0.0,         1.0,                 1,            0.0d],
            [0.0d,         10.0,          0.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          0.0,         10.0,                0,            0.0d],
            [0.0d,         10.0,          0.0,         10.0,                1,            0.0d],
            [0.0d,         10.0,          0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         0.0,                 0,            0.0d],
            [0.0d,         10.0,          1.0,         0.0,                 1,            0.0d],
            [0.0d,         10.0,          1.0,         0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         1.0,                 0,            0.0d],
            [0.0d,         10.0,          1.0,         1.0,                 1,            0.0d],
            [0.0d,         10.0,          1.0,         1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          1.0,         10.0,                0,            0.0d],
            [0.0d,         10.0,          1.0,         10.0,                1,            0.0d],
            [0.0d,         10.0,          1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          10.0,        0.0,                 0,            0.0d],
            [0.0d,         10.0,          10.0,        0.0,                 1,            0.0d],
            [0.0d,         10.0,          10.0,        0.0,                 10,           0.0d],

           // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR     EXPECTED
            [0.0d,         10.0,          10.0,        1.0,                 0,            0.0d],
            [0.0d,         10.0,          10.0,        1.0,                 1,            0.0d],
            [0.0d,         10.0,          10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [0.0d,         10.0,          10.0,        10.0,                0,            0.0d],
            [0.0d,         10.0,          10.0,        10.0,                1,            0.0d],
            [0.0d,         10.0,          10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         0.0,                 0,            0.01d],
            [1.0d,         1.0,           0.0,         0.0,                 1,            0.01d],
            [1.0d,         1.0,           0.0,         0.0,                 10,           0.01d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         1.0,                 0,            0.01d],
            [1.0d,         1.0,           0.0,         1.0,                 1,            0.009d],
            [1.0d,         1.0,           0.0,         1.0,                 10,           0.008d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           0.0,         10.0,                0,            0.01d],
            [1.0d,         1.0,           0.0,         10.0,                1,            0.009d],
            [1.0d,         1.0,           0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         0.0,                 0,            0.01d],
            [1.0d,         1.0,           1.0,         0.0,                 1,            0.009d],
            [1.0d,         1.0,           1.0,         0.0,                 10,           0.009d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         1.0,                 0,            0.01d],
            [1.0d,         1.0,           1.0,         1.0,                 1,            0.009d],
            [1.0d,         1.0,           1.0,         1.0,                 10,           0.007d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           1.0,         10.0,                0,            0.01d],
            [1.0d,         1.0,           1.0,         10.0,                1,            0.008d],
            [1.0d,         1.0,           1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        0.0,                 0,            0.01d],
            [1.0d,         1.0,           10.0,        0.0,                 1,            0.009d],
            [1.0d,         1.0,           10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        1.0,                 0,            0.01d],
            [1.0d,         1.0,           10.0,        1.0,                 1,            0.008d],
            [1.0d,         1.0,           10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         1.0,           10.0,        10.0,                0,            0.01d],
            [1.0d,         1.0,           10.0,        10.0,                1,            0.008d],
            [1.0d,         1.0,           10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         0.0,                 0,            0.1d],
            [1.0d,         10.0,          0.0,         0.0,                 1,            0.1d],
            [1.0d,         10.0,          0.0,         0.0,                 10,           0.1d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         1.0,                 0,            0.1d],
            [1.0d,         10.0,          0.0,         1.0,                 1,            0.099d],
            [1.0d,         10.0,          0.0,         1.0,                 10,           0.084d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          0.0,         10.0,                0,            0.1d],
            [1.0d,         10.0,          0.0,         10.0,                1,            0.09d],
            [1.0d,         10.0,          0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         0.0,                 0,            0.1d],
            [1.0d,         10.0,          1.0,         0.0,                 1,            0.099d],
            [1.0d,         10.0,          1.0,         0.0,                 10,           0.084d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         1.0,                 0,            0.1d],
            [1.0d,         10.0,          1.0,         1.0,                 1,            0.098d],
            [1.0d,         10.0,          1.0,         1.0,                 10,           0.068d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          1.0,         10.0,                0,            0.1d],
            [1.0d,         10.0,          1.0,         10.0,                1,            0.089d],
            [1.0d,         10.0,          1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        0.0,                 0,            0.1d],
            [1.0d,         10.0,          10.0,        0.0,                 1,            0.09d],
            [1.0d,         10.0,          10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        1.0,                 0,            0.1d],
            [1.0d,         10.0,          10.0,        1.0,                 1,            0.089d],
            [1.0d,         10.0,          10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [1.0d,         10.0,          10.0,        10.0,                0,            0.1d],
            [1.0d,         10.0,          10.0,        10.0,                1,            0.08d],
            [1.0d,         10.0,          10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         0.0,                 0,            1.0d],
            [100.0d,       1.0,           0.0,         0.0,                 1,            1.0d],
            [100.0d,       1.0,           0.0,         0.0,                 10,           1.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         1.0,                 0,            1.0d],
            [100.0d,       1.0,           0.0,         1.0,                 1,            0.99d],
            [100.0d,       1.0,           0.0,         1.0,                 10,           0.895d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           0.0,         10.0,                0,            1.0d],
            [100.0d,       1.0,           0.0,         10.0,                1,            0.9d],
            [100.0d,       1.0,           0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         0.0,                 0,            1.0d],
            [100.0d,       1.0,           1.0,         0.0,                 1,            0.99d],
            [100.0d,       1.0,           1.0,         0.0,                 10,           0.895d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         1.0,                 0,            1.0d],
            [100.0d,       1.0,           1.0,         1.0,                 1,            0.98d],
            [100.0d,       1.0,           1.0,         1.0,                 10,           0.79d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           1.0,         10.0,                0,            1.0d],
            [100.0d,       1.0,           1.0,         10.0,                1,            0.89d],
            [100.0d,       1.0,           1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        0.0,                 0,            1.0d],
            [100.0d,       1.0,           10.0,        0.0,                 1,            0.9d],
            [100.0d,       1.0,           10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        1.0,                 0,            1.0d],
            [100.0d,       1.0,           10.0,        1.0,                 1,            0.89d],
            [100.0d,       1.0,           10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       1.0,           10.0,        10.0,                0,            1.0d],
            [100.0d,       1.0,           10.0,        10.0,                1,            0.8d],
            [100.0d,       1.0,           10.0,        10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         0.0,                 0,            10.0d],
            [100.0d,       10.0,          0.0,         0.0,                 1,            10.0d],
            [100.0d,       10.0,          0.0,         0.0,                 10,           10.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         1.0,                 0,            10.0d],
            [100.0d,       10.0,          0.0,         1.0,                 1,            9.9d],
            [100.0d,       10.0,          0.0,         1.0,                 10,           8.406d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          0.0,         10.0,                0,            10.0d],
            [100.0d,       10.0,          0.0,         10.0,                1,            9.0d],
            [100.0d,       10.0,          0.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         0.0,                 0,            10.0d],
            [100.0d,       10.0,          1.0,         0.0,                 1,            9.9d],
            [100.0d,       10.0,          1.0,         0.0,                 10,           8.406d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         1.0,                 0,            10.0d],
            [100.0d,       10.0,          1.0,         1.0,                 1,            9.8d],
            [100.0d,       10.0,          1.0,         1.0,                 10,           6.812d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          1.0,         10.0,                0,            10.0d],
            [100.0d,       10.0,          1.0,         10.0,                1,            8.9d],
            [100.0d,       10.0,          1.0,         10.0,                10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        0.0,                 0,            10.0d],
            [100.0d,       10.0,          10.0,        0.0,                 1,            9.0d],
            [100.0d,       10.0,          10.0,        0.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        1.0,                 0,            10.0d],
            [100.0d,       10.0,          10.0,        1.0,                 1,            8.9d],
            [100.0d,       10.0,          10.0,        1.0,                 10,           0.0d],
            
            // CAPITAL    INTEREST    REDEMPTION    SPECIAL_REDEMPTION    END_OF_YEAR    EXPECTED
            [100.0d,       10.0,          10.0,        10.0,                0,            10.0d],
            [100.0d,       10.0,          10.0,        10.0,                1,            8.0d],
            [100.0d,       10.0,          10.0,        10.0,                10,           0.0d],
            

        ]*.toArray()
    }

    
    @Test
    public void testAccumulationFactorByYearsAndInterest() {
        assertThat(AnnuityCalculator.calculateInterestInYear(capital, interest, redemption, specialRedemption, endOfYear)).isCloseTo(expected, offset(0.001d))
    }

}
