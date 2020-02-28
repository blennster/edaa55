
%% Diffekv D1
yprim = @(t, y) 9 * t + 4 * exp(-0.3 * t) - 2 * y^2;
[t, y] = ode45(yprim, [0 6], 8);
y(end)

plot(t, y)


%% Kurvanpassning D2
x = [ 0.000 1.000 2.000 3.000 4.000 5.000 ];
y = [ 3.749 4.689 6.273 5.897 6.381 7.003 ];

hold on
axis([-10 10 3 8])

plot(x, y, '+')

poly = polyfit(x, y, 5);
xfit = -10:10;
yfit = polyval(poly, xfit);
plot(xfit, yfit);

poly2 = polyfit(x, y, 1);
yfit2 = polyval(poly2, xfit);
plot(xfit, yfit2);

%% Antagande D3

x = [ 0.10 0.20 0.30 0.40 0.50 0.60 0.70 0.80 0.90 1.00 1.10 1.20 1.30 1.40 1.50 ];
y = [ 1.19 1.17 1.20 1.20 1.37 1.34 1.46 1.55 1.38 1.59 1.63 1.67 1.69 1.72 1.88 ];

w = y.^2;
p = polyfit(x, w, 1);

a = sqrt(p(1));
b = p(2) / p(1);

y1 = @(x) a .* sqrt(x+b);
x1 = linspace(0, 2, 50);

hold on
plot(x, y, '.')
plot(x1, y1(x1))


%% Analys av mätdata D4, D5, D6
v = csvread('race.txt');
[count, ~] = size(v);
x = linspace(0, 40, count);

peak = find(v > 80);

v(peak) = v(peak - 1);
max(v) % Max
plot(x, v)

mean(v) % Medelhastighet
S = trapz(x, v) % Numerisk integrering
save = v(450);

%% Mer analys D7, D8

v = csvread('const_accel.txt');
[count, ~] = size(v);
x = linspace(0, 5, count);
p = polyfit(x, v.', 1);
acc = p(1)

hold on;
plot(x, v)
plot(x, polyval(p, x))

%% Krafter D9, D10
M = 1171.42;
r = 0.3515;
C = 0.24;
A = 2.4;
p = 1.29;

fm = 4 * M / r;
fl = @(v) -C * p * A * v^2 / 2;
ftot = @(v) fm + fl(v);

m = 2107.9;
a = @(t, v) ftot(v) / m;
[t, veloc] = ode45(a, [0 3], 0);
max(veloc)

%% D11
max(veloc)
save

% Felet kan vara från mycket, felkalibrering av sensor, för dålig modell