clear
clc

%% Konstanter
m = 0.1;
k = 40;
dx = 0.014; % i m
omega_sqr = k / m;
omega_0 = sqrt(omega_sqr);
b = 0.4;

x = linspace(0, 1, 1000);


%% Uppgift 1

figure(1) % 1.a
xt1 = @(t) dx * cos(omega_0*t);

plot(x, xt1(x))
title('Position mot tid')
xlabel('\itt\rm / s')
ylabel('\itx\rm / m')

figure(2) % 1.b
vt1 = @(t) -omega_0 * dx * sin(omega_0*t);

plot(x, vt1(x))
title('Hastighet mot tid')
xlabel('\itt\rm / s')
ylabel('\itv\rm / m/s')

figure(3) % 1.c
plot(xt1(x), vt1(x))
title('Hastighet mot position')
xlabel('\itx\rm / m')
ylabel('\itv\rm / m/s')

%% Uppgift 2
figure(4) % 2.a och b
t_halfA = log(1/2) * 2 * m / -b; % Halveringstid

omega_prim = omega_0 * sqrt(1 - (b / (2 * m * omega_0))^2);
tau = m / b;

xt2 = @(t) dx * exp(-t / (2 * tau)) .* cos(omega_prim * t);

plot(x, xt2(x))
xline(t_halfA)
title('Position mot tid')
xlabel('\itt\rm / s')
ylabel('\itx\rm / m')

figure(5) % 2.c
vt2 = @(t) dx / (2 * tau) * dx * exp(-t / (2 * tau)) .* -sin(omega_prim * t) * omega_prim;

plot(xt2(x), vt2(x))
title('Hastighet mot position')
xlabel('\itx\rm / m')
ylabel('\itv\rm / m/s')

%% Uppgift 3
% a) Amplituden ökar

figure(6)
F0 = k * dx;

A = @(w)F0 ./ sqrt(m^2 * (omega_0^2 - w.^2).^2 + b^2*w.^2);

x1 = linspace(0, 2 * omega_0);
plot(x1 ./ omega_0, A(x1) ./ dx)
title('Amplitud mot vinkelfrekvens')
xlabel('\it\omega\rm / {\omega_0}')
ylabel('\itA\rm / A_0')

%% Uppgift 4

L = 12 * 10^-3;
C = 1.6 * 10^-6;

omega = sqrt(1 / (L * C));
omega_prim = 1 * 10^3 * 2 * pi;

R = sqrt(1 - (omega_prim / omega)^2) * 2 * L * omega;


