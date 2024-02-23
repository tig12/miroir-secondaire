/**
    Computes the size and position of the secondary mirror of a Newton telescope.
    
    Usage :
    - Adapt the values of variables f, D, fpp, d, h in method main()
        See docs/index.html to understand the meaning of variables.
        A letter 'p' stands for 'prime' (ex : fp means f', fpp means f'').
    - run: java SecondaryMirror.java
    
    Released under the General Public Licence, version 3 or later,
    available at https://www.gnu.org/licenses/gpl-3.0.en.html
    Copyright Thierry Graff, 2001
**/

public class SecondaryMirror {
    public static void main(String[] args) {
        double f = 1260;
        double D = 253;
        double fpp = 3.18;
        double d = 11.0;
        double h= 60.0;
        calcSecondaryMiror(f, D, fpp, d, h);
    }
    
    /** 
    Given characteristics of the telescope, calculates the size and position of the secondaty mirror.
    @param f    focale
    @param D    diameter of the primary mirror
    @param fpp  fleche
    @param d    pupille de sortie
    @param h    depassement du plan focal sur le bord du telescope
    **/
    public static void calcSecondaryMiror(double f,
                                          double D,
                                          double fpp,
                                          double d,
                                          double h){
        double V2 = Math.sqrt(2);

        System.out.println("f = " + f);
        System.out.println("D = " + D);
        System.out.println("f'' = " + fpp);
        System.out.println("d = " + d);
        System.out.println("h = " + h);

        double R = D/2;
        double r = d/2;
        double fp = f - fpp;
        double hp = fp-R-h;

        double l = d*fp/(D-d);
        double ApBp = D*(fp+l-hp)/(fp+l);

        double alpha = Math.atan(R/fp);
        double alphaDeg = Math.toDegrees(alpha);

        double gamma = Math.atan(R/(fp+l));
        double cg = Math.cos(gamma);
        double c2g = Math.cos(2*gamma);
        double sg = Math.sin(gamma);
        double gammaDeg = Math.toDegrees(gamma);

        // Size of the secondary mirror (major axis of the ellipse)
        double AB = Math.sqrt(2)*ApBp*cg*cg/c2g;

        System.out.println("\n=============\n");
        System.out.println("h' = " + hp);
        System.out.println("l = " + l);
        System.out.println("A'B' = " + ApBp);
        System.out.println("alpha (deg)    = " + alphaDeg);
        System.out.println("gamma (deg)    = " + gammaDeg);
        System.out.println("AB = " + AB);

        // obstruction from the secondary miror
        double r1 = AB/V2;
        double percent = 100*r1*r1/(R*R);
        double percent2 = 100*r1/R;

        System.out.println("\n=============\n");
        System.out.println("obstruction (surface) : " + percent + " %");
        System.out.println("obstruction (radius) : " + percent2 + " %");

        // position of the center
        double CCp = ApBp * cg / c2g * (1 - cg + sg);
        double delta = CCp/V2;
        double yC = R - delta;
        double zC = hp - delta;

        // minor axis of the ellipse
        double CA1 = ApBp/2 + CCp/V2*(sg/cg - 1);

        System.out.println("\n=============\n");
        System.out.println("CC' : " + CCp);
        System.out.println("delta : " + delta);
        System.out.println("yC : " + yC);
        System.out.println("zC : " + zC);
        System.out.println("\n");
        System.out.println("CA1 : " + CA1);
        System.out.println("A1B1 : " + CA1*2);
        
    }

} // end class
