package Blocks;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

class Appearance {

        private Stop[] stops1 = new Stop[] {
                new Stop(0, Color.rgb(20, 184, 20)),
                new Stop(1, Color.rgb(163, 245, 163))
        };

        LinearGradient linearGradient1 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops1);

        private Stop[] stops2 = new Stop[] {
                new Stop(0, Color.rgb(212, 212, 17)),
                new Stop(1, Color.rgb(247, 247, 161))
        };

        LinearGradient linearGradient2 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops2);

        private Stop[] stops3 = new Stop[] {
                new Stop(0, Color.rgb(236, 106, 19)),
                new Stop(1, Color.rgb(247, 195, 161))
        };

        LinearGradient linearGradient3 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops3);

        private Stop[] stops4 = new Stop[] {
                new Stop(0, Color.rgb(211, 57, 18)),
                new Stop(1, Color.rgb(247, 178, 161))
        };

        LinearGradient linearGradient4 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops4);

        private Stop[] stops5 = new Stop[] {
                new Stop(0, Color.rgb(240, 66, 153)),
                new Stop(1, Color.rgb(249, 185, 217)	)
        };

        LinearGradient linearGradient5 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops5);

        private Stop[] stops6 = new Stop[] {
                new Stop(0, Color.rgb(156, 22, 22)	),
                new Stop(1, Color.rgb(236, 121, 121)	)
        };

        LinearGradient linearGradient6 =
                new LinearGradient(0, 1, 0, 0, true, CycleMethod.NO_CYCLE, stops6);
}