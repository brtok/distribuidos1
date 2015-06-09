﻿using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteWebService
{
    public partial class JanelaRelatorioLocacoes : Form
    {
        public JanelaRelatorioLocacoes()
        {
            InitializeComponent();
            panelLocacoes.Visible = false;
            WebServiceCliente wsc = new WebServiceCliente();
            List<Veiculo> veiculos = wsc.RecuperarVeiculos();
            if (veiculos.Count != 0)
            {
                comboVeiculos.DataSource = veiculos;
                comboVeiculos.DisplayMember = "descricaoParaCombo";
            }
        }

        private void botaoAvancar_Click(object sender, EventArgs e)
        {
            if (comboVeiculos.SelectedItem == null)
            {
                MessageBox.Show("Selecione um carro", "Cliente", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
            else
            {
                listaLocacoes.Clear();
                Veiculo selecionado = (Veiculo) comboVeiculos.SelectedItem;
                labelLocVeic.Text = "Relatório de Locações para o Veículo " + selecionado.getIdVeiculo()
                    + "-" + selecionado.getModelo();

                WebServiceCliente wsc = new WebServiceCliente();
                List<Locacao> locacoes = wsc.RecuperarLocacoesPorVeiculo(selecionado.getIdVeiculo());

                foreach (Locacao l in locacoes)
                {
                    String linha = "De " + l.getDataHoraRetirada().Day.ToString();
                    linha = linha + "/" + l.getDataHoraRetirada().Month.ToString();
                    linha = linha + "/" + l.getDataHoraRetirada().Year.ToString();
                    linha = linha + " as " + l.getDataHoraRetirada().Hour.ToString() + ":";
                    if (l.getDataHoraRetirada().Minute < 10)
                    {
                        linha = linha + "0";
                    }
                    linha = linha + l.getDataHoraRetirada().Minute.ToString();

                    linha = linha + " com retirada no " + l.getLocalRetirada();

                    linha = linha + " e devolução " + l.getDataHoraDevolucao().Day.ToString();
                    linha = linha + "/" + l.getDataHoraDevolucao().Month.ToString();
                    linha = linha + "/" + l.getDataHoraDevolucao().Year.ToString();
                    linha = linha + " as " + l.getDataHoraDevolucao().Hour.ToString() + ":";
                    if (l.getDataHoraDevolucao().Minute < 10)
                    {
                        linha = linha + "0";
                    }
                    linha = linha + l.getDataHoraDevolucao().Minute.ToString();

                    linha = linha + " no " + l.getLocalDevolucao();

                    listaLocacoes.Items.Add(linha);
                }
                panelCarro.Visible = false;
                panelLocacoes.Visible = true;
            }
        }

        private void botaoVoltar_Click(object sender, EventArgs e)
        {
            panelLocacoes.Visible = false;
            panelCarro.Visible = true;
        }
    }
}
