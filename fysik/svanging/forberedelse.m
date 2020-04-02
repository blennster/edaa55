%% Konstanter
clear

m = 0.1;
k = 40;
dx = 14; % i mmm
omega_sqr = k / m;
x = linspace(0, 1, 1000);


%% Uppgift 1
xt = @(t) dx * cos(sqrt(omega_sqr)*t);

plot(x, xt(x))
title('Position mot tid')
xlabel('\itt\rm / s')
ylabel('\itx\rm / mm')


%% Uppgift 2

vt = diff(xt(x));
vt = [0 vt]; % Eftersom diff bara är numerisk derivata så finns inte 0 med

plot(x, vt)
title('Fart mot tid')
xlabel('\itt\rm / s')
ylabel('\itv\rm / mm/s')


%% Uppgift 3

plot(xt(x), vt)
title('Fart mot position')
xlabel('\itx\rm / mm')
ylabel('\itv\rm / mm/s')
