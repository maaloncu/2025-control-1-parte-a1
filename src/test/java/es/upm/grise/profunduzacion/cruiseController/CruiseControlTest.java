package es.upm.grise.profunduzacion.cruiseController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;


class CruiseControlTest {

    private CruiseControl cc;

    @BeforeEach
    void setUp() {
        cc = new CruiseControl(new Speedometer() {
            @Override
            public int getCurrentSpeed() {
                return 0;
            }
        });
    }

    @Test
    void defaultValuesAreNull() {
        assertNull(cc.getSpeedSet(), "speedSet debería ser null por defecto");
        assertNull(cc.getSpeedLimit(), "speedLimit debería ser null por defecto");
    }

    @Test
    void settingValidSpeedStoresValue() {
        cc.setSpeedSet(50);
        assertEquals(Integer.valueOf(50), cc.getSpeedSet());
    }

    @Test
    void settingZeroOrNegativeThrowsIncorrectSpeedSetException() {
        assertThrows(Exception.class, () -> cc.setSpeedSet(0));
        assertThrows(Exception.class, () -> cc.setSpeedSet(-10));
    }

    @Test
    void settingAboveLimitThrowsSpeedSetAboveSpeedLimitException() {
        cc.setSpeedLimit(100);
        assertThrows(Exception.class, () -> cc.setSpeedSet(120));
    }

    @Test
    void settingAtOrBelowLimitAllowed() {
        cc.setSpeedLimit(100);
        cc.setSpeedSet(100);
        assertEquals(Integer.valueOf(100), cc.getSpeedSet());
        cc.setSpeedSet(80);
        assertEquals(Integer.valueOf(80), cc.getSpeedSet());
    }
	
}
