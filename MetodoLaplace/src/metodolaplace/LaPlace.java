package metodolaplace;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LaPlace {

    int[][] matriz3X3;
    BufferedImage imagem;
    BufferedImage imagemFinal;
    int[][] matAux;
    int altura;
    int largura;

    public LaPlace() throws IOException {
        imagem = ImageIO.read(new File("image.jpg"));
        matriz3X3 = new int[3][3];
        altura = imagem.getHeight();
        largura = imagem.getWidth();
        imagemFinal = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        matAux = new int[largura][altura];

    }

    public void setValues3X3() {
        matriz3X3[0][0] = 1;
        matriz3X3[0][1] = 1;
        matriz3X3[0][2] = 1;
        matriz3X3[1][0] = 1;
        matriz3X3[1][1] = -8;
        matriz3X3[1][2] = 1;
        matriz3X3[2][0] = 1;
        matriz3X3[2][1] = 1;
        matriz3X3[2][2] = 1;

    }

    public void laplaceMethod() throws IOException {
        this.setValues3X3();
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                Color c = new Color(imagem.getRGB(i, j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int gray = (r + g + b) / 3;
                matAux[i][j] = gray;

            }
        }
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                try {

                    int valorTotal = matAux[i][j] * matriz3X3[1][1];

                    valorTotal += matAux[i + 1][j] * matriz3X3[1][2];
                    valorTotal += matAux[i][j + 1] * matriz3X3[2][1];
                    valorTotal += matAux[i - 1][j] * matriz3X3[1][0];
                    valorTotal += matAux[i][j - 1] * matriz3X3[0][1];
                    valorTotal += matAux[i - 1][j - 1] * matriz3X3[0][0];
                    valorTotal += matAux[i + 1][j + 1] * matriz3X3[2][2];
                    valorTotal += matAux[i - 1][j + 1] * matriz3X3[2][0];
                    valorTotal += matAux[i + 1][j - 1] * matriz3X3[0][2];
                    if (valorTotal < 0) {
                        valorTotal = valorTotal * -1;
                    }
                    if (valorTotal > 255) {
                        valorTotal = 255;
                    }
                    Color c = new Color(valorTotal, valorTotal, valorTotal);
                    imagemFinal.setRGB(i, j, c.getRGB());
                } catch (ArrayIndexOutOfBoundsException ex) {
                    if (j == 0) {
                        if (i == 0) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i + 1][j] * matriz3X3[1][2];
                            valorTotal += matAux[i][j + 1] * matriz3X3[2][1];
                            valorTotal += matAux[i + 1][j] * matriz3X3[2][2];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 3;
                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }
                        if (i == largura - 1) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i - 1][j] * matriz3X3[1][0];
                            valorTotal += matAux[i][j + 1] * matriz3X3[2][0];
                            valorTotal += matAux[i - 1][j + 1] * matriz3X3[2][1];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 3;
                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }
                        if (i != 0 && i != largura - 1) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i - 1][j] * matriz3X3[1][0];
                            valorTotal += matAux[i - 1][j + 1] * matriz3X3[2][0];
                            valorTotal += matAux[i][j + 1] * matriz3X3[2][1];
                            valorTotal += matAux[i + 1][j + 1] * matriz3X3[2][2];
                            valorTotal += matAux[i + 1][j] * matriz3X3[1][2];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 4;
                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }

                    }
                    if (j == altura - 1) {
                        if (i == 0) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i + 1][j] * matriz3X3[1][2];
                            valorTotal += matAux[i][j - 1] * matriz3X3[0][1];
                            valorTotal += matAux[i + 1][j - 1] * matriz3X3[0][2];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 3;
                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }
                        if (i == largura - 1) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i - 1][j] * matriz3X3[1][0];
                            valorTotal += matAux[i][j - 1] * matriz3X3[2][0];
                            valorTotal += matAux[i - 1][j - 1] * matriz3X3[2][1];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 3;

                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }
                        if (i != 0 && i != largura - 1) {
                            int valorTotal = matAux[i][j] * matriz3X3[1][1];
                            valorTotal += matAux[i - 1][j] * matriz3X3[1][0];
                            valorTotal += matAux[i - 1][j - 1] * matriz3X3[0][0];
                            valorTotal += matAux[i][j - 1] * matriz3X3[0][1];
                            valorTotal += matAux[i + 1][j - 1] * matriz3X3[0][2];
                            valorTotal += matAux[i + 1][j] * matriz3X3[1][2];
                            if (valorTotal < 0) {
                                valorTotal = valorTotal * -1;
                            }
                            valorTotal = valorTotal / 4;

                            if (valorTotal > 255) {
                                valorTotal = 255;
                            }
                            Color c = new Color(valorTotal, valorTotal, valorTotal);
                            imagemFinal.setRGB(i, j, c.getRGB());

                        }

                    }

                }

            }
        }
        ImageIO.write(imagemFinal, "jpg", new File("Imagem laplace.jpg"));
    }

}
