package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorapp.ui.ComposeCalculatorTheme
import com.example.calculatorapp.ui.LightGray
import com.example.calculatorapp.ui.MediumGray
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/
        setContent {
            ComposeCalculatorTheme{
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MediumGray)
                        .padding(16.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ){
                        Text(
                            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = Color.White,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ){
                            CalculatorButton(
                                symbol = "AC",
                                modifier = Modifier
                                    .background(LightGray)
                                    .aspectRatio(2f)
                                    .weight(2f)

                            ){
                                viewModel.onAction(CalculatorAction.Clear)
                            }
                            CalculatorButton(
                                symbol = "Del",
                                modifier = Modifier
                                    .background(LightGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Delete)
                            }

                            CalculatorButton(
                                symbol = "/",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                            }
                            CalculatorButton(
                                symbol = "√",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                                ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Root))
                            }


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ){
                            CalculatorButton(
                                symbol = "7",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(7))
                            }
                            CalculatorButton(
                                symbol = "8",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(8))
                            }

                            CalculatorButton(
                                symbol = "9",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(9))
                            }
                            CalculatorButton(
                                symbol = "x",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                            }
                            CalculatorButton(
                                symbol = "log",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                                ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.log))
                            }

                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ){
                            CalculatorButton(
                                symbol = "4",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(4))
                            }
                            CalculatorButton(
                                symbol = "5",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(5))
                            }

                            CalculatorButton(
                                symbol = "6",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(CalculatorAction.Number(6))
                            }
                            CalculatorButton(
                                symbol = "-",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                            }
                            CalculatorButton(
                                symbol = "^",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                                ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Power))
                            }

                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ){
                            CalculatorButton(
                                symbol = "1",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(1))
                            }
                            CalculatorButton(
                                symbol = "2",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(2))
                            }

                            CalculatorButton(
                                symbol = "3",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(3))
                            }
                            CalculatorButton(
                                symbol = "+",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                            }

                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing),


                            ){
                            CalculatorButton(
                                symbol = "0",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(2f)
                                    .weight(2f),

                            ){
                                viewModel.onAction(CalculatorAction.Number(0))
                            }
                            CalculatorButton(
                                symbol = ".",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Decimal)
                            }

                            CalculatorButton(
                                symbol = "=",
                                modifier = Modifier
                                    .background(Color.Cyan)
                                    .aspectRatio(1f)
                                    .weight(1f),

                            ){
                                viewModel.onAction(CalculatorAction.Calculate)
                            }


                        }
                    }
                }

            }
        }
    }
}