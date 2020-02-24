%% Komplexa tal är najs

a = 3 + 2i;
b = 5 - 1i;
x = a * b

% Kan bara se resulatet från den sista eftersom de andra har ;

%% Deriv
h = 1e-6;
deriv = @(f,x) (f(x + h) - f(x)) / h;

%% Funktioner
g = @(x)exp(-0.1.*x) .* cos(x);

% x = (1:100) .* 0.1;
x = linspace(1, 10);
y = g(x);
yprim = deriv(g, x);

hold on
plot(x, y)
plot(x, yprim, 'red')
legend('g(x)', 'g''(x)')
title('Funktionen och dess derivata')
hold off

%% Jämför derivator
h1 = @(x)exp(-0.1.*x) .* cos(x) - 0.1.*exp(-0.1 .* x) .* sin(x);
y1 = h1(x);

h2 = @(x)-0.1.*exp(-0.1.*x) .* cos(x) - exp(-0.1 .* x) .* sin(x);
y2 = h2(x);

h3 = @(x)-0.1.*exp(-0.1.*x) .* cos(x) - 0.1.*exp(-0.1 .* x) .* sin(x);
y3 = h3(x);

hold on
title('Bent, Alva och Kit försöker derivera')
plot(x, yprim)
plot(x, y1)
plot(x, y2)
plot(x, y3)
legend('g''', 'y1', 'y2', 'y3')
hold off

d1 = yprim - y1;
d2 = yprim - y2;
d3 = yprim - y3;

norm(d1)
norm(d2)
norm(d3)

%% Matris

M = [7*eye(5) 9*ones(5, 3)]'

vl = [5, 10, 5;
      5, 5, 10;
      8, 4, 4];
hl = [0;
      -5;
      -12];
x = vl\hl;
vl*x % Sant

A = [1, 1, -1;
     2, 1, 1;
     4, 3, -1];

det(A)

Evl = [1, 1, -1;
     2, 1, 1;
     4, 3, -1];
Ehl = [2; 3; 4];
Eans = Evl\Ehl; % Finns ingen lösning enligt ekv E != 0 <=> Finns lösning för y


