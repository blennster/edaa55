function [sy, sv, sa] = simulate(Ff, Fg, m)
     dt = 0.02;

     sy = [0];
     sv = [0];
     sa = [Fg];
     Ftot = @(v)Fg * m - Ff(v);

     for i = 1:99
         sa(i+1) = Ftot(sv(i)) / m;
         sy(i+1) = sy(i) + sv(i) * dt;
         sv(i+1) = sv(i) + sa(i) * dt;
     end
end