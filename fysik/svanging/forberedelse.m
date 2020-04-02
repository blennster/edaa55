clear
clc

%% Konstanter
m = 0.1;
k = 40;
dx = 14; % i mmm
omega_sqr = k / m;
omega = sqrt(omega_sqr);
b = 0.4;

x = linspace(0, 1, 1000);


%% Uppgift 1

figure(1) % 1.a
xt = @(t) dx * cos(omega*t);

plot(x, xt(x))
title('Position mot tid')
xlabel('\itt\rm / s')
ylabel('\itx\rm / mm')

figure(2) % 1.b
vt = diff(xt(x));
vt = [0 vt]; % Eftersom diff bara �r numerisk derivata s� finns inte 0 med

plot(x, vt)
title('Fart mot tid')
xlabel('\itt\rm / s')
ylabel('\itv\rm / mm/s')

figure(3) % 1.c
plot(xt(x), vt)
title('Fart mot position')
xlabel('\itx\rm / mm')
ylabel('\itv\rm / mm/s')

%% Uppgift 2
figure(4)

t_halfA = log(1/2) * 2 * m / -b;

omega_prim = omega * sqrt(1 - (b / (2 * m * omega))^2);

xt = @(t) dx * exp(-t * (b/(2 * m))) .* cos(omega_prim * t);

plot(x, xt(x))
xline(t_halfA)
title('Position mot tid')
xlabel('\itt\rm / s')
ylabel('\itx\rm / mm')

figure(5)
vt = diff(xt(x));
vt = [0 vt];

plot(xt(x), vt)

%% Uppgift 3
