package com.odhiambopaul.rewards.presentation.ui.reward.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.odhiambopaul.rewards.domain.model.Reward

@Composable
fun RewardListItem(reward: Reward, onItemClick: (Reward) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .clickable { onItemClick(reward) }
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp), elevation = 10.dp) {
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "${reward.id}. ${reward.name}",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "List ID: ${reward.listId}",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

    }
}